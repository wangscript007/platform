package cn.elvea.platform.commons.persistence.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DbType
 *
 * @author elvea
 */
@Getter
@AllArgsConstructor
public enum DbType {

    /**
     * MYSQL
     */
    MYSQL("mysql", "MySQL"),

    /**
     * PostgreSQL
     */
    POSTGRESQL("postgresql", "POSTGRESQL"),

    /**
     * Oracle
     */
    ORACLE("oracle", "Oracle"),

    /**
     * Unknown
     */
    UNKNOWN("unknown", "Unknown");

    /**
     * 数据库名称
     */
    private final String db;
    /**
     * 描述
     */
    private final String desc;

    public static DbType getDbType(String dbType) {
        for (DbType type : DbType.values()) {
            if (type.db.equalsIgnoreCase(dbType)) {
                return type;
            }
        }
        return UNKNOWN;
    }

}
