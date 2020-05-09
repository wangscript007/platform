package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.RolePermissionRelationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RolePermissionRepository
 *
 * @author elvea
 */
@Repository
public interface RolePermissionRelationRepository
        extends CrudRepository<RolePermissionRelationEntity, Long> {
}
