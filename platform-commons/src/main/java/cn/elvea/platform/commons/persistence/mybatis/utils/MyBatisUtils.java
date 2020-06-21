package cn.elvea.platform.commons.persistence.mybatis.utils;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Optional;

/**
 * MyBatisUtils
 *
 * @author elvea
 */
@SuppressWarnings("ALL")
public abstract class MyBatisUtils {

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
                    }
                }
            } else if (parameterObject instanceof Pageable) {
                return Optional.of((Pageable) parameterObject);
            }
        }
        return Optional.empty();
    }

}
