package cn.elvea.platform.commons.persistence.mybatis.utils;

import cn.elvea.platform.commons.persistence.mybatis.PageableRequest;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * MyBatisUtils
 *
 * @author elvea
 */
public abstract class MyBatisUtils {

    /**
     * 获取真实代理对象
     */
    public static Object getTarget(Object target) {
        if (Proxy.isProxyClass(target.getClass())) {
            MetaObject metaObject = SystemMetaObject.forObject(target);
            return getTarget(metaObject.getValue("h.target"));
        }
        return target;
    }

    /**
     * 获取真实代理对象
     *
     * @param target Object
     * @param <T>    T
     * @return T
     */
    public static <T> T getRealTarget(Object target) {
        if (Proxy.isProxyClass(target.getClass())) {
            MetaObject metaObject = SystemMetaObject.forObject(target);
            return getRealTarget(metaObject.getValue("h.target"));
        }
        return (T) target;
    }

    /**
     * 查找分页对象参数
     *
     * @param parameterObject {@link Object}
     * @return Optional<Pageable>
     */
    public static Optional<Pageable> findPageable(Object parameterObject) {
        if (parameterObject != null) {
            if (parameterObject instanceof Map) {
                Map<?, ?> parameterMap = (Map<?, ?>) parameterObject;
                for (Map.Entry entry : parameterMap.entrySet()) {
                    if (entry.getValue() != null && entry.getValue() instanceof Pageable) {
                        return Optional.of((Pageable) entry.getValue());
                    } else if (entry.getValue() != null && entry.getValue() instanceof Page) {
                        return Optional.of(((Page) entry.getValue()).getPageable());
                    }
                }
            } else if (parameterObject instanceof Pageable) {
                return Optional.of((Pageable) parameterObject);
            } else if (parameterObject instanceof Page) {
                return Optional.of(((Page) parameterObject).getPageable());
            }
        }
        return Optional.empty();
    }

    /**
     * 查找分页对象参数
     *
     * @param parameterObject {@link Object}
     * @return Optional<Pageable>
     */
    public static Optional<PageableRequest<?>> findPageableRequest(Object parameterObject) {
        if (parameterObject != null) {
            if (parameterObject instanceof Map) {
                Map<?, ?> parameterMap = (Map<?, ?>) parameterObject;
                for (Map.Entry entry : parameterMap.entrySet()) {
                    if (entry.getValue() != null && entry.getValue() instanceof PageableRequest) {
                        return Optional.of((PageableRequest) entry.getValue());
                    } else if (entry.getValue() != null && entry.getValue() instanceof Pageable) {
                        return Optional.of(new PageableRequest((Pageable) entry.getValue(), false));
                    }
                }
            } else if (parameterObject instanceof PageableRequest) {
                return Optional.of((PageableRequest) parameterObject);
            } else if (parameterObject instanceof Pageable) {
                return Optional.of(new PageableRequest(((Pageable) parameterObject), false));
            }
        }
        return Optional.empty();
    }

    /**
     * 获取方法返回类型
     *
     * @param mappedStatement {@link MappedStatement}
     * @return Class
     */
    public static Class<?> getReturnType(MappedStatement mappedStatement) {
        try {
            String id = mappedStatement.getId();
            Class<?> mapperInterface = Class.forName(id.substring(0, id.lastIndexOf(".")));
            String methodName = id.substring(id.lastIndexOf(".") + 1);
            Method method = BeanUtils.findMethod(mapperInterface, methodName);
            return method.getReturnType();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 复制MappedStatement
     *
     * @param ms           {@link MappedStatement}
     * @param newSqlSource {@link SqlSource}
     * @return {@link MappedStatement}
     */
    public static MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(
                ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType()
        );
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        String[] keyProperties = ms.getKeyProperties();
        builder.keyProperty(keyProperties == null ? null : keyProperties[0]);
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    /**
     * 复制BoundSql
     *
     * @param mappedStatement ${@link MappedStatement}
     * @param boundSql        ${@link BoundSql}
     * @param sql             SQL
     * @param parameter       参数
     * @return {@link BoundSql}
     */
    public static BoundSql copyFromBoundSql(MappedStatement mappedStatement,
                                            BoundSql boundSql,
                                            String sql,
                                            Object parameter) {

        List<ParameterMapping> parameterMappings = new ArrayList<>(boundSql.getParameterMappings());

        BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), sql, parameterMappings, parameter);

        for (ParameterMapping mapping : boundSql.getParameterMappings()) {
            String prop = mapping.getProperty();
            if (boundSql.hasAdditionalParameter(prop)) {
                newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
            }
        }
        return newBoundSql;
    }

}
