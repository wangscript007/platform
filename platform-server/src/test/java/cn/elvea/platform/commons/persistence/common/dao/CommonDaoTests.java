package cn.elvea.platform.commons.persistence.common.dao;

import cn.elvea.ApplicationBaseTests;
import cn.elvea.platform.commons.persistence.jdbc.dao.CommonDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * CommonDaoTests
 *
 * @author elvea
 */
public class CommonDaoTests extends ApplicationBaseTests {

    @Autowired
    CommonDao commonDao;

    @Test
    public void test() {
        Assertions.assertNotNull(commonDao);

        LocalDateTime currentLocalDateTime = this.commonDao.getCurrentLocalDateTime();
        Assertions.assertNotNull(currentLocalDateTime);

        LocalDate currentLocalDate = this.commonDao.getCurrentLocalDate();
        Assertions.assertNotNull(currentLocalDate);

        LocalTime currentLocalTime = this.commonDao.getCurrentLocalTime();
        Assertions.assertNotNull(currentLocalTime);

    }

}
