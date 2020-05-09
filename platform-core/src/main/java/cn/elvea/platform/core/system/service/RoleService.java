package cn.elvea.platform.core.system.service;

import cn.elvea.platform.core.system.dto.RoleTypeDto;

/**
 * RoleService
 *
 * @author elvea
 */
public interface RoleService {

    RoleTypeDto findRoleTypeByCode(String code);

}
