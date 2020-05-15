package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.jpa.service.AbstractService;
import cn.elvea.platform.commons.utils.ConvertUtils;
import cn.elvea.platform.core.system.domain.UserEntity;
import cn.elvea.platform.core.system.dto.UserDto;
import cn.elvea.platform.core.system.repository.UserRepository;
import cn.elvea.platform.core.system.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @see UserService
 */
@Service
public class UserServiceImpl extends AbstractService<Long, UserEntity, UserRepository>
        implements UserService {

    /**
     * @see UserService#findByUsername(String)
     */
    public UserDto findByUsername(String username) {
        UserEntity userEntity = this.repository.findByUsername(username);
        return ConvertUtils.convert(userEntity, UserDto.class);
    }

}
