package cn.elvea.platform.core.system.service;

import cn.elvea.platform.core.system.dto.UserDto;

/**
 * UserService
 *
 * @author elvea
 */
public interface UserService {

    /**
     * 根据用户名查找用户
     */
    UserDto findByUsername(String username);

}
