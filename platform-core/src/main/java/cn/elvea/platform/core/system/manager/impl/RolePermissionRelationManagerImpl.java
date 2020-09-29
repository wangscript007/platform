package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.service.AbstractManager;
import cn.elvea.platform.core.system.domain.RolePermissionRelationEntity;
import cn.elvea.platform.core.system.manager.RolePermissionRelationManager;
import cn.elvea.platform.core.system.repository.RolePermissionRelationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import static cn.elvea.platform.core.system.SystemConstants.CACHE_ROLE_PERMISSION_RELATION;

/**
 * RolePermissionRelationManager
 *
 * @author elvea
 */
@Service
@Slf4j
@CacheConfig(cacheNames = CACHE_ROLE_PERMISSION_RELATION)
public class RolePermissionRelationManagerImpl
        extends AbstractManager<RolePermissionRelationEntity, Long, RolePermissionRelationRepository>
        implements RolePermissionRelationManager {

    /**
     * @see RolePermissionRelationManager#clearCache()
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public void clearCache() {
        if (log.isDebugEnabled()) {
            log.debug("Clear cache [{}]...", CACHE_ROLE_PERMISSION_RELATION);
        }
    }

}
