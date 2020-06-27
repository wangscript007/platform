package cn.elvea.platform.commons.persistence.jdbc.dao;

import cn.elvea.platform.commons.persistence.common.dialect.DbDialect;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * JDBC Dao 通用基础类
 *
 * @author elvea
 */
public class CommonDao {

    private JdbcTemplate jdbcTemplate;

    private DbDialect dbDialect;

    public CommonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 获取数据库系统当前时间
     *
     * @return 数据库系统当前时间
     */
    public LocalDateTime getCurrentLocalDateTime() {
        return this.jdbcTemplate.queryForObject("select now()", java.time.LocalDateTime.class);
    }

    /**
     * 获取数据库系统当前时间
     *
     * @return 数据库系统当前时间
     */
    public LocalDate getCurrentLocalDate() {
        return this.jdbcTemplate.queryForObject("select curdate()", java.time.LocalDate.class);
    }

    /**
     * 获取数据库系统当前时间
     *
     * @return 数据库系统当前时间
     */
    public LocalTime getCurrentLocalTime() {
        return this.jdbcTemplate.queryForObject("select curtime()", java.time.LocalTime.class);
    }

}
