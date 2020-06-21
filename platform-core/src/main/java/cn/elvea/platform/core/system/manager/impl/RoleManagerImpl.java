package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.system.domain.RoleEntity;
import cn.elvea.platform.core.system.manager.RoleManager;
import cn.elvea.platform.core.system.manager.RoleTypeManager;
import cn.elvea.platform.core.system.manager.UserManager;
import cn.elvea.platform.core.system.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import static cn.elvea.platform.core.system.SystemConstants.CACHE_ROLE;

/**
 * RoleManager
 *
 * @author elvea
 * @see RoleManager
 */
@Slf4j
@Service
@CacheConfig(cacheNames = CACHE_ROLE)
public class RoleManagerImpl
        extends AbstractService<RoleEntity, Long, RoleRepository>
        implements RoleManager {

    /**
     * @see UserManager#findById(Serializable)
     */
    @Override
    @Cacheable(key = "'id-' + #id")
    public RoleEntity findById(Long id) {
        return super.findById(id);
    }

    /**
     * @see RoleTypeManager#clearCache()
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public void clearCache() {
        if (log.isDebugEnabled()) {
            log.debug("Clear cache [{}]...", CACHE_ROLE);
        }
    }

}
