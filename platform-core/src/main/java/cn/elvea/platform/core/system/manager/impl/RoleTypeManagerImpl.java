package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.service.AbstractManager;
import cn.elvea.platform.core.system.domain.RoleTypeEntity;
import cn.elvea.platform.core.system.manager.RoleTypeManager;
import cn.elvea.platform.core.system.manager.UserManager;
import cn.elvea.platform.core.system.repository.RoleTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import static cn.elvea.platform.core.system.SystemConstants.CACHE_ROLE_TYPE;

/**
 * RoleTypeManager
 *
 * @author elvea
 * @see RoleTypeManager
 */
@Slf4j
@Service
@CacheConfig(cacheNames = CACHE_ROLE_TYPE)
public class RoleTypeManagerImpl
        extends AbstractManager<RoleTypeEntity, Long, RoleTypeRepository>
        implements RoleTypeManager {

    /**
     * @see UserManager#findById(Serializable)
     */
    @Override
    @Cacheable(key = "'id-' + #id")
    public RoleTypeEntity findById(Long id) {
        return super.findById(id);
    }

    /**
     * @see RoleTypeManager#findByCode(String)
     */
    @Override
    @Cacheable(key = "'code-' + #code")
    public RoleTypeEntity findByCode(String code) {
        return this.repository.findByCode(code);
    }

    /**
     * @see RoleTypeManager#clearCache()
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public void clearCache() {
        if (log.isDebugEnabled()) {
            log.debug("Clear cache [{}]...", CACHE_ROLE_TYPE);
        }
    }

}
