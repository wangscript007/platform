package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.RolePermissionRelationEntity;
import org.springframework.stereotype.Repository;

/**
 * RolePermissionRepository
 *
 * @author elvea
 */
@Repository
public interface RolePermissionRelationRepository extends JdbcRepository<RolePermissionRelationEntity, Long> {
}
