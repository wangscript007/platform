package cn.elvea.platform.commons.jpa.support;

import org.springframework.dao.DataAccessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * NativeCallback
 *
 * @author elvea
 */
public interface NativeCallback {
    void execute(Connection con) throws SQLException, DataAccessException;
}
