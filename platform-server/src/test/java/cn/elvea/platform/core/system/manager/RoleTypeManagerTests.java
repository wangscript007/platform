package cn.elvea.platform.core.system.manager;

import cn.elvea.ApplicationBaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * RoleTypeManagerTests
 *
 * @author elvea
 */
public class RoleTypeManagerTests extends ApplicationBaseTests {

    @Autowired
    RoleTypeManager roleTypeManager;

    @Test
    public void test() {
        Assertions.assertNotNull(this.roleTypeManager);
    }

}
