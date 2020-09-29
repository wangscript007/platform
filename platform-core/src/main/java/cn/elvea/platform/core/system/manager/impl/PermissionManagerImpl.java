package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.service.AbstractManager;
import cn.elvea.platform.core.system.domain.PermissionEntity;
import cn.elvea.platform.core.system.manager.PermissionManager;
import cn.elvea.platform.core.system.repository.PermissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import static cn.elvea.platform.core.system.SystemConstants.CACHE_PERMISSION;

/**
 * EntityRelationManager
 *
 * @author elvea
 */
@Service
@Slf4j
@CacheConfig(cacheNames = CACHE_PERMISSION)
public class PermissionManagerImpl
        extends AbstractManager<PermissionEntity, Long, PermissionRepository>
        implements PermissionManager {

    /**
     * @see PermissionManager#clearCache()
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public void clearCache() {
        if (log.isDebugEnabled()) {
            log.debug("Clear cache [{}]...", CACHE_PERMISSION);
        }
    }

}
