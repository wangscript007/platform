package cn.elvea.platform.commons.utils;

import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.Map;

/**
 * CollectionUtils
 *
 * @author elvea
 */
public abstract class CollectionUtils extends org.springframework.util.CollectionUtils {

    /**
     * 是否不为空
     */
    public static boolean isNotEmpty(@Nullable Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 是否不为空
     */
    public static boolean isNotEmpty(@Nullable Map<?, ?> map) {
        return !isEmpty(map);
    }

}
