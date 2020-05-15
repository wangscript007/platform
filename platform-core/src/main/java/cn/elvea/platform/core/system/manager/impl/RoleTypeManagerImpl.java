package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.jpa.service.AbstractService;
import cn.elvea.platform.core.system.domain.RoleTypeEntity;
import cn.elvea.platform.core.system.manager.RoleTypeManager;
import cn.elvea.platform.core.system.repository.RoleTypeRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import static cn.elvea.platform.core.system.SystemConstants.CACHE_ROLE_TYPE;

/**
 * RoleTypeManager
 *
 * @author elvea
 * @see RoleTypeManager
 */
@Service
public class RoleTypeManagerImpl extends AbstractService<Long, RoleTypeEntity, RoleTypeRepository>
        implements RoleTypeManager {

    /**
     * @see RoleTypeManager#findOneByCode(String)
     */
    @Cacheable(value = CACHE_ROLE_TYPE, key = "#code")
    @Override
    public RoleTypeEntity findOneByCode(String code) {
        RoleTypeEntity condition = RoleTypeEntity.builder().code(code).build();
        return this.repository.findOne(Example.of(condition)).orElseThrow();
    }

}
