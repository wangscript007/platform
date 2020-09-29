package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.service.AbstractManager;
import cn.elvea.platform.core.system.domain.UserRoleRelationEntity;
import cn.elvea.platform.core.system.manager.RolePermissionRelationManager;
import cn.elvea.platform.core.system.manager.UserRoleRelationManager;
import cn.elvea.platform.core.system.repository.UserRoleRelationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import static cn.elvea.platform.core.system.SystemConstants.CACHE_USER_ROLE_RELATION;

/**
 * RolePermissionRelationManager
 *
 * @author elvea
 * @see RolePermissionRelationManager
 */
@Service
@Slf4j
@CacheConfig(cacheNames = CACHE_USER_ROLE_RELATION)
public class UserRoleRelationManagerImpl
        extends AbstractManager<UserRoleRelationEntity, Long, UserRoleRelationRepository>
        implements UserRoleRelationManager {

    /**
     * @see RolePermissionRelationManager#clearCache()
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public void clearCache() {
        if (log.isDebugEnabled()) {
            log.debug("Clear cache [{}]...", CACHE_USER_ROLE_RELATION);
        }
    }

}
