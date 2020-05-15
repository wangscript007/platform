package cn.elvea.platform.core.system.service;

import cn.elvea.ApplicationBaseTests;
import cn.elvea.platform.core.system.dto.RoleTypeDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ApplicationBaseTests
 *
 * @author elvea
 */
public class RoleTypeServiceTests extends ApplicationBaseTests {

    @Autowired
    private RoleTypeService roleTypeService;

    @Test
    public void testFindByUsername() {
        RoleTypeDto dto = this.roleTypeService.findRoleTypeByCode("SYSTEM_ADMINISTRTOR");
        Assertions.assertNotNull(dto);
    }

}
