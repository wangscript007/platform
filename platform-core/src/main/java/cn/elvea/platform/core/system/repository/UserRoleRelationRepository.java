package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.UserRoleRelationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRoleRelationRepository
 *
 * @author elvea
 */
@Repository
public interface UserRoleRelationRepository
        extends CrudRepository<UserRoleRelationEntity, Long> {
}
