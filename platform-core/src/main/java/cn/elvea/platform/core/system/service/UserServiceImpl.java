package cn.elvea.platform.core.system.service;

import cn.elvea.platform.commons.jpa.service.AbstractBaseService;
import cn.elvea.platform.commons.utils.ConvertUtils;
import cn.elvea.platform.core.system.domain.UserEntity;
import cn.elvea.platform.core.system.dto.UserDto;
import cn.elvea.platform.core.system.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @see UserService
 */
@Service
public class UserServiceImpl
        extends AbstractBaseService<UserRepository, UserEntity, Long>
        implements UserService {

    /**
     * @see UserService#findByUsername(String)
     */
    public UserDto findByUsername(String username) {
        UserEntity userEntity = this.repository.findByUsername(username);
        return ConvertUtils.convert(userEntity, UserDto.class);
    }

}
