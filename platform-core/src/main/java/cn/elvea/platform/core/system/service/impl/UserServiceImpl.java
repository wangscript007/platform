package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.utils.ConvertUtils;
import cn.elvea.platform.core.system.domain.UserEntity;
import cn.elvea.platform.core.system.dto.UserDto;
import cn.elvea.platform.core.system.manager.UserManager;
import cn.elvea.platform.core.system.manager.UserRoleRelationManager;
import cn.elvea.platform.core.system.service.UserService;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author elvea
 * @see UserService
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserManager userManager;

    private final UserRoleRelationManager userRoleRelationManager;

    public UserServiceImpl(UserManager userManager,
                           UserRoleRelationManager userRoleRelationManager) {
        this.userManager = userManager;
        this.userRoleRelationManager = userRoleRelationManager;
    }

    /**
     * @see UserService#findByUsername(String)
     */
    public UserDto findByUsername(String username) {
        UserEntity userEntity = this.userManager.findByUsername(username);
        if (userEntity != null) {
        }
        return ConvertUtils.convert(userEntity, UserDto.class);
    }

}
