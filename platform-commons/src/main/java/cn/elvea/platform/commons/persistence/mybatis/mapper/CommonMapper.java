package cn.elvea.platform.commons.persistence.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * MyBatis通用基础Mapper
 *
 * @author elvea
 */
@Mapper
public interface CommonMapper {

    /**
     * 获取数据库系统当前时间
     *
     * @return 数据库系统当前时间
     */
    LocalDateTime getCurrentLocalDateTime();

    /**
     * 获取数据库系统当前时间
     *
     * @return 数据库系统当前时间
     */
    LocalDate getCurrentLocalDate();

    /**
     * 获取数据库系统当前时间
     *
     * @return 数据库系统当前时间
     */
    LocalTime getCurrentLocalTime();

}
