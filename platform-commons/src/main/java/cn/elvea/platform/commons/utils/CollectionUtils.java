package cn.elvea.platform.commons.utils;

import org.springframework.lang.Nullable;

import java.util.Collection;

/**
 * CollectionUtils
 *
 * @author elvea
 */
public abstract class CollectionUtils extends org.springframework.util.CollectionUtils {

    /**
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(@Nullable Collection<?> collection) {
        return !isEmpty(collection);
    }

}
