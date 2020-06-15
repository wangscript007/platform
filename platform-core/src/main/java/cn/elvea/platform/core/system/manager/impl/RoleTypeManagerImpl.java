package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.system.domain.RoleTypeEntity;
import cn.elvea.platform.core.system.manager.RoleTypeManager;
import cn.elvea.platform.core.system.repository.RoleTypeRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static cn.elvea.platform.core.system.SystemConstants.CACHE_ROLE_TYPE;

/**
 * RoleTypeManager
 *
 * @author elvea
 * @see RoleTypeManager
 */
@Service
public class RoleTypeManagerImpl
        extends AbstractService<RoleTypeEntity, Long, RoleTypeRepository>
        implements RoleTypeManager {

    /**
     * @see RoleTypeManager#findByCode(String)
     */
    @Cacheable(value = CACHE_ROLE_TYPE, key = "#code")
    @Override
    public RoleTypeEntity findByCode(String code) {
        RoleTypeEntity condition = RoleTypeEntity.builder().code(code).build();
        return null;
    }

}
