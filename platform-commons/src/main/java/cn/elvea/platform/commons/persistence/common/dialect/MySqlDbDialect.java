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

}
