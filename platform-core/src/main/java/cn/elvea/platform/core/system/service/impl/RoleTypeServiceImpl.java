package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.utils.ConvertUtils;
import cn.elvea.platform.core.system.domain.RoleTypeEntity;
import cn.elvea.platform.core.system.dto.RoleTypeDto;
import cn.elvea.platform.core.system.manager.RoleTypeManager;
import cn.elvea.platform.core.system.service.RoleTypeService;
import org.springframework.stereotype.Service;

/**
 * RoleTypeService
 *
 * @author elvea
 * @see RoleTypeService
 */
@Service
public class RoleTypeServiceImpl implements RoleTypeService {

    private final RoleTypeManager roleTypeManager;

    public RoleTypeServiceImpl(RoleTypeManager roleTypeManager) {
        this.roleTypeManager = roleTypeManager;
    }

    @Override
    public RoleTypeDto findRoleTypeByCode(String code) {
        RoleTypeEntity entity = this.roleTypeManager.findOneByCode(code);
        return ConvertUtils.convert(entity, RoleTypeDto.class);
    }

}
