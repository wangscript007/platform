package cn.elvea.platform.core.system.service;

import cn.elvea.ApplicationBaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ApplicationBaseTests
 *
 * @author elvea
 */
public class RoleServiceTests extends ApplicationBaseTests {

    @Autowired
    private RoleService roleService;

    @Test
    public void test() {
        Assertions.assertNotNull(roleService);
    }

}
