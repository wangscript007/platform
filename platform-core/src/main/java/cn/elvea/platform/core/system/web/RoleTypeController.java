package cn.elvea.platform.core.system.web;

import cn.elvea.platform.commons.web.WebResponse;
import cn.elvea.platform.core.system.dto.RoleTypeDto;
import cn.elvea.platform.core.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Role_Type", tags = "角色类型")
public class RoleTypeController {

    private final RoleService roleService;

    public RoleTypeController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 查询单个角色类型
     *
     * @return 查询结果
     */
    @ApiOperation(value = "查询用户详细", notes = "查询用户详细")
    @PostMapping(value = "/find-by-code")
    public WebResponse<RoleTypeDto> getById(@RequestBody String code) {
        return WebResponse.success(this.roleService.findRoleTypeByCode(code));
    }

}
