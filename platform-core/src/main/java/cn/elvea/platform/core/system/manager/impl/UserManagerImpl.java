package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.system.SystemConstants;
import cn.elvea.platform.core.system.domain.UserEntity;
import cn.elvea.platform.core.system.manager.UserManager;
import cn.elvea.platform.core.system.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * UserManager
 *
 * @author elvea
 * @see UserManager
 */
@Service
public class UserManagerImpl extends AbstractService<UserEntity, Long, UserRepository> implements UserManager {

    /**
     * @see UserManager#findById(Serializable)
     */
    @Override
    @Cacheable(value = SystemConstants.CACHE_USER, key = "'id-' + #id")
    public UserEntity findById(Long id) {
        return super.findById(id);
    }

    /**
     * @see UserManager#findByUsername(String)
     */
    @Override
    @Cacheable(value = SystemConstants.CACHE_USER, key = "'username-' + #username")
    public UserEntity findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    /**
     * @see UserManager#findByEmail(String)
     */
    @Override
    @Cacheable(value = SystemConstants.CACHE_USER, key = "'email-' + #email")
    public UserEntity findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    /**
     * @see UserManager#findByMobile(String, String)
     */
    @Override
    @Cacheable(value = SystemConstants.CACHE_USER, key = "'mobile-' + #mobileCountryCode + '-' + #mobile")
    public UserEntity findByMobile(String mobileCountryCode, String mobile) {
        return this.repository.findByMobileCountryCodeAndMobile(mobileCountryCode, mobile);
    }

}
