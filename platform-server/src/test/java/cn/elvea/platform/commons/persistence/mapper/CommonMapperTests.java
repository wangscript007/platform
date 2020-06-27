package cn.elvea.platform.commons.persistence.mapper;

import cn.elvea.ApplicationBaseTests;
import cn.elvea.platform.commons.persistence.mybatis.mapper.CommonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * CommonMapperTests
 *
 * @author elvea
 */
public class CommonMapperTests extends ApplicationBaseTests {

    @Autowired
    CommonMapper commonMapper;

    @Test
    public void test() {
        Assertions.assertNotNull(commonMapper);

        LocalDateTime currentLocalDateTime = this.commonMapper.getCurrentLocalDateTime();
        Assertions.assertNotNull(currentLocalDateTime);

        LocalDate currentLocalDate = this.commonMapper.getCurrentLocalDate();
        Assertions.assertNotNull(currentLocalDate);

        LocalTime currentLocalTime = this.commonMapper.getCurrentLocalTime();
        Assertions.assertNotNull(currentLocalTime);

    }

}
