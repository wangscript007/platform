package cn.elvea.platform.core.system.manager;

import cn.elvea.ApplicationBaseTests;
import cn.elvea.platform.core.system.domain.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserManagerTests
 *
 * @author elvea
 */
public class UserManagerTests extends ApplicationBaseTests {

    @Autowired
    UserManager userManager;

    @Test
    public void test() {

        Assertions.assertNotNull(this.userManager);

        UserEntity userEntity1 = this.userManager.findById(1L);
        UserEntity userEntity2 = this.userManager.findByUsername("admin");
        UserEntity userEntity3 = this.userManager.findByEmail("platform@host.com");
        UserEntity userEntity4 = this.userManager.findByMobile("86", "13800138000");

        Assertions.assertNotNull(userEntity1);
        Assertions.assertNotNull(userEntity2);
        Assertions.assertNotNull(userEntity3);
        Assertions.assertNotNull(userEntity4);

        System.out.println("1");

    }

}

