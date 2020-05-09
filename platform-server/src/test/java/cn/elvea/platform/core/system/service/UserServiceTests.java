package cn.elvea.platform.core.system.service;

import cn.elvea.ApplicationBaseWebTests;
import cn.elvea.platform.core.system.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserServiceTest
 *
 * @author elvea
 */
public class UserServiceTests extends ApplicationBaseWebTests {

    @Autowired
    private UserService userService;

    @Test
    public void testFindByUsername() {
        UserDto userDto = this.userService.findByUsername("admin");
        Assertions.assertNotNull(userDto);
    }

}
