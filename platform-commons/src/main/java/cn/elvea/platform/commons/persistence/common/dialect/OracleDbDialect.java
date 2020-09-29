package cn.elvea.platform.commons.persistence.common.dialect;

/**
 * OracleDbDialect
 *
 * @author elvea
 */
public class OracleDbDialect implements DbDialect {

    /**
     * @see DbDialect#buildCreateSimpleTemporaryTableSql(String)
     */
    @Override
    public String buildCreateSimpleTemporaryTableSql(String temporaryTableName) {
        return String.format("create global temporary table %s (id number(19)) on commit preserve rows ", temporaryTableName);
    }

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
