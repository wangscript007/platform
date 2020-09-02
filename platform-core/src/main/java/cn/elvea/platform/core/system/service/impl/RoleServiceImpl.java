package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.system.domain.RoleEntity;
import cn.elvea.platform.core.system.dto.RoleDto;
import cn.elvea.platform.core.system.manager.EntityRelationManager;
import cn.elvea.platform.core.system.manager.RoleManager;
import cn.elvea.platform.core.system.manager.RoleTypeManager;
import cn.elvea.platform.core.system.repository.RoleRepository;
import cn.elvea.platform.core.system.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RoleService
 *
 * @author elvea
 * @see RoleService
 */
@Service
public class RoleServiceImpl
        extends AbstractService<RoleEntity, Long, RoleRepository>
        implements RoleService {

    private final RoleManager roleManager;

    private final RoleTypeManager roleTypeManager;

    public RoleServiceImpl(RoleManager roleManager, RoleTypeManager roleTypeManager) {
        this.roleManager = roleManager;
        this.roleTypeManager = roleTypeManager;
    }

    /**
     * @see EntityRelationManager#getParents(String, long)
     */
    @Override
    public List<RoleDto> findRoleByUserId(Long userId) {
        return null;
    }

}
