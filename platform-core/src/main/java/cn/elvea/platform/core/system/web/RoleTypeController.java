package cn.elvea.platform.core.system.web;

import cn.elvea.platform.commons.web.WebResponse;
import cn.elvea.platform.core.system.dto.RoleTypeDto;
import cn.elvea.platform.core.system.service.RoleService;
import cn.elvea.platform.core.system.service.RoleTypeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RoleController
 *
 * @author elvea
 */
@Slf4j
@RestController
@RequestMapping("/role-type")
public class RoleTypeController {

    private final RoleService roleService;

    private final RoleTypeService roleTypeService;

    public RoleTypeController(RoleService roleService,
                              RoleTypeService roleTypeService) {
        this.roleService = roleService;
        this.roleTypeService = roleTypeService;
    }

    /**
     * 查询单个角色类型
     *
     * @return 查询结果
     */
    @Operation()
    @PostMapping(value = "/find-by-code")
    public WebResponse<RoleTypeDto> getById(@RequestBody String code) {
        return WebResponse.success(this.roleTypeService.findRoleTypeByCode(code));
    }

}
