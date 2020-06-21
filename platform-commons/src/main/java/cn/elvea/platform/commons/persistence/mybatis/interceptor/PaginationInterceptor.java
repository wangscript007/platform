package cn.elvea.platform.commons.persistence.mybatis.interceptor;

import cn.elvea.platform.commons.persistence.common.DbType;
import cn.elvea.platform.commons.persistence.common.dialect.DbDialect;
import cn.elvea.platform.commons.persistence.common.utils.JdbcUtils;
import cn.elvea.platform.commons.persistence.mybatis.utils.MyBatisUtils;
import cn.elvea.platform.commons.utils.CollectionUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.*;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.springframework.data.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

/**
 * PaginationInterceptor
 *
 * @author elvea
 */
@Slf4j
@Setter
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class PaginationInterceptor implements Interceptor {

    /**
     * 数据库类型
     */
    private DbType dbType;

    /**
     * 数据库放眼
     */
    private DbDialect dbDialect;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = MyBatisUtils.getRealTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);

        // 先判断是不是查询操作或者存储过程，这些无需做分页操作
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        if (SqlCommandType.SELECT != mappedStatement.getSqlCommandType()
                || StatementType.CALLABLE == mappedStatement.getStatementType()) {
            return invocation.proceed();
        }

        // 针对定义了rowBounds，做为mapper接口方法的参数
        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        Object paramObj = boundSql.getParameterObject();

        // 判断参数里是否有Pageable对象
        Pageable pageable = MyBatisUtils.findPageable(paramObj).orElse(null);
        // 不包含Pageable参数的时候，或者每页记录数小于等于零的时候，无需做分页操作
        if (null == pageable || pageable.getPageSize() < 0) {
            return invocation.proceed();
        }


        String originalSql = boundSql.getSql();
        Connection connection = (Connection) invocation.getArgs()[0];

        Page<?> page = this.queryTotal(dbDialect.buildCountSql(boundSql.getSql()), mappedStatement, boundSql, pageable, connection);
        if (page.getTotalElements() <= 0) {
            return null;
        }

        DbType dbType = this.dbType == null ? JdbcUtils.getDbType(connection) : this.dbType;
        DbDialect dialect = Optional.ofNullable(this.dbDialect).orElseGet(() -> JdbcUtils.getDialect(dbType));
        String buildSql = concatOrderBy(originalSql, pageable);
        String paginationSql = dialect.buildPaginationSql(buildSql, pageable.getOffset(), pageable.getPageSize());
        List<ParameterMapping> mappings = new ArrayList<>(boundSql.getParameterMappings());
        metaObject.setValue("delegate.boundSql.sql", paginationSql);
        metaObject.setValue("delegate.boundSql.parameterMappings", mappings);
        return invocation.proceed();
    }

    /**
     * 查询总记录条数
     *
     * @param sql             SQL
     * @param mappedStatement MappedStatement
     * @param boundSql        BoundSql
     * @param pageable        Pageable
     * @param connection      Connection
     */
    protected Page<Object> queryTotal(String sql, MappedStatement mappedStatement, BoundSql boundSql, Pageable pageable, Connection connection) {
        Page page = new PageImpl(Collections.EMPTY_LIST);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            DefaultParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), boundSql);
            parameterHandler.setParameters(statement);
            long total = 0;
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    total = resultSet.getLong(1);
                }
            }
            page = new PageImpl<>(Collections.EMPTY_LIST, page.getPageable(), total);
            if (pageable.getPageNumber() > page.getTotalPages()) {
                page = new PageImpl<>(Collections.EMPTY_LIST, PageRequest.of(
                        pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort()
                ), total);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    /**
     * 查询SQL拼接Order By
     *
     * @param originalSql 需要拼接的SQL
     * @param pageable    分页对象
     * @return ignore
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

    private static List<OrderByElement> addOrderByElements(List<Sort.Order> orderList, List<OrderByElement> orderByElements) {
        orderByElements = CollectionUtils.isEmpty(orderByElements) ? new ArrayList<>(orderList.size()) : orderByElements;
        List<OrderByElement> orderByElementList = orderList.stream()
                .map(item -> {
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
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }

}
