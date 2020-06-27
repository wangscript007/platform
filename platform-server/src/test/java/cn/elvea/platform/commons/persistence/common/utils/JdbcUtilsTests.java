package cn.elvea.platform.commons.persistence.common.utils;

import cn.elvea.ApplicationBaseWebTests;
import cn.elvea.platform.commons.sequence.IdWorker;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcUtilsTests
 *
 * @author elvea
 */
public class JdbcUtilsTests extends ApplicationBaseWebTests {

    @Autowired
    IdWorker idWorker;

    @Autowired
    DataSource dataSource;

    @Test
    public void createTemporaryTableTest() throws SQLException {
        String temporaryTableName = null;
        Connection connection = null;
        try {
            List<Long> idList = Lists.newArrayList();
            for (int i = 0; i < 1000000; i++) {
                idList.add(idWorker.nextId());
            }
            connection = this.dataSource.getConnection();
            long startTime = System.currentTimeMillis();
            temporaryTableName = JdbcUtils.createTemporaryTable(connection, idList);
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (StringUtils.isNotEmpty(temporaryTableName)) {
                JdbcUtils.dropTemporaryTable(connection, temporaryTableName);
            }
            JdbcUtils.close(connection);
        }
    }

}
