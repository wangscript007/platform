package cn.elvea.platform.commons.persistence.common.utils;

import cn.elvea.platform.commons.exception.SystemException;
import cn.elvea.platform.commons.persistence.common.DbType;
import cn.elvea.platform.commons.persistence.common.dialect.DbDialect;
import cn.elvea.platform.commons.persistence.common.dialect.MySqlDbDialect;
import cn.elvea.platform.commons.persistence.common.dialect.OracleDbDialect;
import cn.elvea.platform.commons.persistence.common.dialect.PostgreSqlDbDialect;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.sql.*;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * JdbcUtils
 *
 * @author elvea
 */
@Slf4j
public abstract class JdbcUtils {

    private final static Map<DbType, DbDialect> dialectEnumMap = new EnumMap<>(DbType.class);

    static {
        dialectEnumMap.put(DbType.MYSQL, new MySqlDbDialect());
        dialectEnumMap.put(DbType.POSTGRESQL, new PostgreSqlDbDialect());
        dialectEnumMap.put(DbType.ORACLE, new OracleDbDialect());
    }

    public static DatabaseMetaData getMetaData(Connection con) throws SQLException {
        Assert.notNull(con, "Connection must not be null.");
        return con.getMetaData();
    }

    public static DbType getDbType(Connection con) throws SQLException {
        Assert.notNull(con, "Connection must not be null.");
        return getDbType(getMetaData(con).getURL());
    }

    public static DbType getDbType(String connectionUrl) {
        Assert.notNull(connectionUrl, "URL must not be null.");
        String url = connectionUrl.toLowerCase();
        if (url.contains(":mysql:") || url.contains(":cobar:")) {
            return DbType.MYSQL;
        } else if (url.contains(":mariadb:")) {
            return DbType.MYSQL;
        } else if (url.contains(":oracle:")) {
            return DbType.ORACLE;
        } else if (url.contains(":postgresql:")) {
            return DbType.POSTGRESQL;
        } else {
            log.warn("The jdbc url is {}, Cannot get Database type or The Database is Not Supported!", connectionUrl);
            return DbType.UNKNOWN;
        }
    }

    public static DbDialect getDialect(DbType dbType) {
        return Optional.ofNullable(dialectEnumMap.get(dbType))
                .orElseThrow(() -> new SystemException(String.format("%s database not supported.", dbType.getDb())));
    }

    /**
     * 创建简单临时表
     */
    public static String createTemporaryTable(Connection con, List<Long> data) throws SQLException {
        // 生成临时表名
        String temporaryTableName = "tmp_" + ((int) (Math.random() * 100000)) + "_" + System.currentTimeMillis();

        Statement createTemporaryStatement = null;
        PreparedStatement insertStatement = null;
        try {
            // 获取数据库类型
            DbDialect dialect = getDialect(getDbType(con));

            // 创建临时表
            createTemporaryStatement = con.createStatement();
            createTemporaryStatement.execute(dialect.buildCreateSimpleTemporaryTableSql(temporaryTableName));

            // 初始临时数据
            insertStatement = con.prepareStatement(String.format("insert into %s (id) values(?); ", temporaryTableName));
            if (data != null && !data.isEmpty()) {
                for (Long val : data) {
                    insertStatement.setLong(1, val);
                    insertStatement.addBatch();
                }
            }
            insertStatement.executeBatch();

            return temporaryTableName;
        } catch (Exception e) {
            log.error("Create temporary table {} failure. ", temporaryTableName, e);
            throw new SQLException(String.format("Create temporary table %s failure.", temporaryTableName));
        } finally {
            close(createTemporaryStatement);
            close(insertStatement);
        }
    }

    /**
     * 移除临时表
     *
     * @param temporaryTableName 临时表名
     */
    public static void dropTemporaryTable(Connection con, String temporaryTableName) throws SQLException {
        if (!Strings.isNullOrEmpty(temporaryTableName)) {
            Statement dropTemporaryStatement = null;
            try {
                dropTemporaryStatement = con.createStatement();
                dropTemporaryStatement.execute(String.format("truncate table %s", temporaryTableName));
                dropTemporaryStatement.execute(String.format("drop table %s", temporaryTableName));
            } catch (Exception e) {
                log.error("Drop temporary table {} failure.", temporaryTableName, e);
                throw new SQLException(String.format("Drop temporary table %s failure.", temporaryTableName));
            } finally {
                close(dropTemporaryStatement);
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt) {
        close(rs);
        close(stmt);
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                log.error("Could not close JDBC Statement", ex);
            } catch (Throwable ex) {
                log.error("Unexpected exception on closing JDBC Statement", ex);
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                log.trace("Could not close JDBC ResultSet", ex);
            } catch (Throwable ex) {
                log.trace("Unexpected exception on closing JDBC ResultSet", ex);
            }
        }
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                log.trace("Could not close JDBC Connection", ex);
            } catch (Throwable ex) {
                log.trace("Unexpected exception on closing JDBC Connection", ex);
            }
        }
    }

}
