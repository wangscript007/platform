package cn.elvea.platform.commons.persistence.common.dialect;

/**
 * MySqlDbDialect
 *
 * @author elvea
 */
public class MySqlDbDialect implements DbDialect {

    /**
     * @see DbDialect#buildPaginationSql(String, long, long)
     */
    @Override
    public String buildPaginationSql(String originalSql, long offset, long limit) {
        return originalSql.concat(" limit ").concat(String.valueOf(limit)).concat(", ").concat(String.valueOf(offset));
    }

    /**
     * @see DbDialect#buildCurrentDateTimeSql()
     */
    @Override
    public String buildCurrentDateTimeSql() {
        return "select now();";
    }

    /**
     * @see DbDialect#buildCurrentDateSql()
     */
    @Override
    public String buildCurrentDateSql() {
        return "select curdate();";
    }

    /**
     * @see DbDialect#buildCurrentTimeSql()
     */
    @Override
    public String buildCurrentTimeSql() {
        return "select curtime();";
    }

}
