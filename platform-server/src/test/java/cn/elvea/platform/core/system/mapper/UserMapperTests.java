package cn.elvea.platform.core.system.mapper;

import cn.elvea.ApplicationBaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * UserMapperTests
 *
 * @author elvea
 */
public class UserMapperTests extends ApplicationBaseTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        Date now = this.userMapper.search();
        Assertions.assertNotNull(this.userMapper);
    }

}
