package cn.elvea.platform.commons.persistence.common.dialect;

/**
 * PostgreSqlDbDialect
 *
 * @author elvea
 */
public class PostgreSqlDbDialect implements DbDialect {

    /**
     * @see DbDialect#buildPaginationSql(String, long, long)
     */
    @Override
    public String buildPaginationSql(String originalSql, long offset, long limit) {
        return null;
    }

    @Override
    public String buildCurrentDateTimeSql() {
        return null;
    }

    @Override
    public String buildCurrentDateSql() {
        return null;
    }

    @Override
    public String buildCurrentTimeSql() {
        return null;
    }

}
