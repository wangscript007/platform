package cn.elvea.platform.commons.jpa.support;

import org.springframework.dao.DataAccessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ReturningNativeCallback
 *
 * @author elvea
 */
public interface ReturningNativeCallback<T> {
    T execute(Connection con) throws SQLException, DataAccessException;
}
