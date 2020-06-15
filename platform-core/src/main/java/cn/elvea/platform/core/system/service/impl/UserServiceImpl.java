package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.utils.ConvertUtils;
import cn.elvea.platform.core.system.domain.UserEntity;
import cn.elvea.platform.core.system.dto.UserDto;
import cn.elvea.platform.core.system.manager.UserManager;
import cn.elvea.platform.core.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author elvea
 * @see UserService
 */
@Service
public class UserServiceImpl implements UserService {

    private UserManager userManager;

    /**
     * @see UserService#findByUsername(String)
     */
    public UserDto findByUsername(String username) {
        UserEntity userEntity = this.userManager.findByUsername(username);
        return ConvertUtils.convert(userEntity, UserDto.class);
    }

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

}
