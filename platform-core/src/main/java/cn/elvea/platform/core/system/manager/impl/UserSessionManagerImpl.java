package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.system.domain.UserSessionEntity;
import cn.elvea.platform.core.system.manager.UserManager;
import cn.elvea.platform.core.system.manager.UserSessionManager;
import cn.elvea.platform.core.system.repository.UserSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import static cn.elvea.platform.core.system.SystemConstants.CACHE_USER_SESSION;

/**
 * UserManager
 *
 * @author elvea
 * @see UserManager
 */
@Service
@Slf4j
@CacheConfig(cacheNames = CACHE_USER_SESSION)
public class UserSessionManagerImpl
        extends AbstractService<UserSessionEntity, Long, UserSessionRepository>
        implements UserSessionManager {

    /**
     * @see UserManager#clearCache()
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public void clearCache() {
        if (log.isDebugEnabled()) {
            log.debug("Clear cache [{}]...", CACHE_USER_SESSION);
        }
    }

}
