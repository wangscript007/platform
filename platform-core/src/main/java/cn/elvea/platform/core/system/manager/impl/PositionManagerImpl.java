package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.service.AbstractManager;
import cn.elvea.platform.core.system.domain.PositionEntity;
import cn.elvea.platform.core.system.manager.PositionManager;
import cn.elvea.platform.core.system.repository.PositionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import static cn.elvea.platform.core.system.SystemConstants.CACHE_POSITION;

/**
 * PermissionManager
 *
 * @author elvea
 */
@Service
@Slf4j
@CacheConfig(cacheNames = CACHE_POSITION)
public class PositionManagerImpl
        extends AbstractManager<PositionEntity, Long, PositionRepository>
        implements PositionManager {

    /**
     * @see PositionManager#clearCache()
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public void clearCache() {
        if (log.isDebugEnabled()) {
            log.debug("Clear cache [{}]...", CACHE_POSITION);
        }
    }

}
