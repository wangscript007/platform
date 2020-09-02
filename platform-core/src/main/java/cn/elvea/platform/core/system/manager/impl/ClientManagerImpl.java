package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.system.domain.ClientEntity;
import cn.elvea.platform.core.system.manager.ClientManager;
import cn.elvea.platform.core.system.manager.UserManager;
import cn.elvea.platform.core.system.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static cn.elvea.platform.core.system.SystemConstants.CACHE_CLIENT;

/**
 * ClientManager
 *
 * @author elvea
 * @see UserManager
 */
@Service
@Slf4j
@CacheConfig(cacheNames = CACHE_CLIENT)
public class ClientManagerImpl extends AbstractService<ClientEntity, Long, ClientRepository> implements ClientManager {

    /**
     * @see ClientManager#findById(Long)
     */
    @Override
    @Cacheable(key = "'id-' + #id")
    public ClientEntity findById(Long id) {
        return super.findById(id);
    }

    /**
     * @see ClientManager#findByClientId(String)
     */
    @Override
    @Cacheable(key = "'client-id-' + #clientId")
    public ClientEntity findByClientId(String clientId) {
        return this.repository.findByClientId(clientId);
    }

    /**
     * @see ClientManager#clearCache()
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public void clearCache() {
        if (log.isDebugEnabled()) {
            log.debug("Clear client cache [{}]...", CACHE_CLIENT);
        }
    }

}
