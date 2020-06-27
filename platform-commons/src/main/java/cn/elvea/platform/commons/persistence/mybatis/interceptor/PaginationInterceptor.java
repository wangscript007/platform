package cn.elvea.platform.commons.persistence.mybatis.interceptor;

import cn.elvea.platform.commons.persistence.common.DbType;
import cn.elvea.platform.commons.persistence.common.dialect.DbDialect;
import cn.elvea.platform.commons.persistence.common.utils.JdbcUtils;
import cn.elvea.platform.commons.persistence.mybatis.PageableRequest;
import cn.elvea.platform.commons.persistence.mybatis.mapping.BoundSqlSqlSource;
import cn.elvea.platform.commons.persistence.mybatis.utils.MyBatisUtils;
import cn.elvea.platform.commons.utils.CollectionUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.*;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * PaginationInterceptor
 *
 * @author elvea
 */
@Slf4j
@Setter
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
public class PaginationInterceptor implements Interceptor {

    static int MAPPED_STATEMENT_INDEX = 0;
    static int PARAMETER_INDEX = 1;
    static int ROWBOUNDS_INDEX = 2;
    static int RESULT_HANDLER_INDEX = 3;

    /**
     * 数据库类型
     */
    private DbType dbType;

    /**
     * 数据库放眼
     */
    private DbDialect dbDialect;

    @Override
    @SuppressWarnings("unchecked")
    public Object intercept(Invocation invocation) throws Throwable {
        Executor executor = MyBatisUtils.getRealTarget(invocation.getTarget());
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[MAPPED_STATEMENT_INDEX];

        // 查询操作或者存储过程，无需分页
        if (SqlCommandType.SELECT != mappedStatement.getSqlCommandType()
                || StatementType.CALLABLE == mappedStatement.getStatementType()) {
            return invocation.proceed();
        }

        Object parameterObject = invocation.getArgs()[PARAMETER_INDEX];

        // 不包含PageableRequest或者Pageable参数时，无需分页
        PageableRequest<?> pageableRequest = MyBatisUtils.findPageableRequest(parameterObject).orElse(null);
        if (null == pageableRequest || pageableRequest.getPageable() == null ||
                pageableRequest.getPageable().getPageSize() < 0) {
            return invocation.proceed();
        }

        Connection connection = executor.getTransaction().getConnection();

        DbType dbType = this.dbType == null ? JdbcUtils.getDbType(connection) : this.dbType;
        DbDialect dialect = Optional.ofNullable(this.dbDialect).orElseGet(() -> JdbcUtils.getDialect(dbType));

        // 针对定义了rowBounds，做为mapper接口方法的参数
        BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
        String originalSql = boundSql.getSql();

        // 查询总记录数
        long total = 0;
        if (pageableRequest.isQueryTotalCount()) {
            String countSql = dialect.buildCountSql(boundSql.getSql());

            total = this.queryTotal(countSql, mappedStatement, boundSql, connection);

            if (total <= 0) {
                return null;
            }
        }

        Pageable pageable = pageableRequest.getPageable();
        String buildSql = concatOrderBy(originalSql, pageable);
        String paginationSql = dialect.buildPaginationSql(buildSql, pageable.getOffset(), pageable.getPageSize());

        BoundSql newBs = MyBatisUtils.copyFromBoundSql(mappedStatement, boundSql, paginationSql, parameterObject);
        MappedStatement newMs = MyBatisUtils.copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBs));
        args[MAPPED_STATEMENT_INDEX] = newMs;
        args[ROWBOUNDS_INDEX] = RowBounds.DEFAULT;

        Object result = invocation.proceed();
        pageableRequest.setTotal(total);
        pageableRequest.setRecords((List) result);
        return result;
    }

    /**
     * 查询总记录条数
     *
     * @param sql             SQL
     * @param mappedStatement {@link MappedStatement}
     * @param boundSql        {@link BoundSql}
     * @param connection      {@link Connection}
     */
    protected long queryTotal(String sql, MappedStatement mappedStatement, BoundSql boundSql, Connection connection) {
        long total = 0;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            DefaultParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), boundSql);
            parameterHandler.setParameters(statement);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    total = resultSet.getLong(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    /**
     * 查询SQL拼接Order By
     *
     * @param originalSql SQL
     * @param pageable    {@link Pageable}
     * @return SQL
     */
    public String concatOrderBy(String originalSql, Pageable pageable) {
        if (CollectionUtils.isNotEmpty(pageable.getSort().toList())) {
            try {
                List<Sort.Order> orderList = pageable.getSort().toList();
                Select selectStatement = (Select) CCJSqlParserUtil.parse(originalSql);
                if (selectStatement.getSelectBody() instanceof PlainSelect) {
                    PlainSelect plainSelect = (PlainSelect) selectStatement.getSelectBody();
                    List<OrderByElement> orderByElements = plainSelect.getOrderByElements();
                    List<OrderByElement> orderByElementsReturn = addOrderByElements(orderList, orderByElements);
                    plainSelect.setOrderByElements(orderByElementsReturn);
                    return plainSelect.toString();
                } else if (selectStatement.getSelectBody() instanceof SetOperationList) {
                    SetOperationList setOperationList = (SetOperationList) selectStatement.getSelectBody();
                    List<OrderByElement> orderByElements = setOperationList.getOrderByElements();
                    List<OrderByElement> orderByElementsReturn = addOrderByElements(orderList, orderByElements);
                    setOperationList.setOrderByElements(orderByElementsReturn);
                    return setOperationList.toString();
                } else if (selectStatement.getSelectBody() instanceof WithItem) {
                    return originalSql;
                } else {
                    return originalSql;
                }

            } catch (JSQLParserException e) {
                log.warn("failed to concat orderBy from IPage, exception=" + e.getMessage());
            }
        }
        return originalSql;
    }

    private static List<OrderByElement> addOrderByElements(List<Sort.Order> orderList,
                                                           List<OrderByElement> orderByElements) {
        orderByElements = CollectionUtils.isEmpty(orderByElements) ? new ArrayList<>(orderList.size()) : orderByElements;
        List<OrderByElement> orderByElementList = orderList.stream().map(item -> {
            OrderByElement element = new OrderByElement();
            element.setExpression(new Column(item.getProperty()));
            element.setAsc(item.getDirection().isAscending());
            return element;
        }).collect(Collectors.toList());
        orderByElements.addAll(orderByElementList);
        return orderByElements;
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
