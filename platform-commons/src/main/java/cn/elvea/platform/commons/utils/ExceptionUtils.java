package cn.elvea.platform.commons.utils;

/**
 * ExceptionUtils
 *
 * @author elvea
 */
public abstract class ExceptionUtils {

    public static RuntimeException unchecked(Throwable ex) {
        if (ex instanceof RuntimeException) {
            return (RuntimeException) ex;
        } else {
            return new RuntimeException(ex);
        }
    }

}
