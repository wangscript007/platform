package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.UserRoleRelationEntity;
import org.springframework.stereotype.Repository;

/**
 * UserRoleRelationRepository
 *
 * @author elvea
 */
@Repository
public interface UserRoleRelationRepository extends JdbcRepository<UserRoleRelationEntity, Long> {
}
