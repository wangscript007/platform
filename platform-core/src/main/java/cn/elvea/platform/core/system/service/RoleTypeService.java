package cn.elvea.platform.core.system.service;

import cn.elvea.platform.core.system.dto.RoleTypeDto;

/**
 * RoleTypeService
 *
 * @author elvea
 */
public interface RoleTypeService {
    RoleTypeDto findRoleTypeByCode(String code);
}
