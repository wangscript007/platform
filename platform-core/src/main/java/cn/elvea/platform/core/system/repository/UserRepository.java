package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 *
 * @author elvea
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    /**
     * 根据用户名查找用户
     */
    UserEntity findByUsername(String username);

}
