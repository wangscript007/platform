package cn.elvea.platform.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtils
 *
 * @author elvea
 */
public abstract class DateUtils {

    public final static String DATE_PATTEN = "";

    public final static String DATETIME_PATTEN = "";

    /**
     * 格式化日期
     */
    public static String format(Object date) {
        return format(date, DATE_PATTEN);
    }

    /**
     * 格式化日期
     */
    public static String format(Object date, String pattern) {
        if (date == null) {
            return null;
        }
        if (pattern == null) {
            return format(date);
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 获取日期
     */
    public static String getDate() {
        return format(new Date());
    }

    /**
     * 获取日期时间
     */
    public static String getDateTime() {
        return format(new Date(), DATETIME_PATTEN);
    }

    /**
     * 获取日期
     */
    public static String getDateTime(String pattern) {
        return format(new Date(), pattern);
    }

}
