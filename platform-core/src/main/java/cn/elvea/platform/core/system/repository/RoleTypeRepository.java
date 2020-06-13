package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.RoleTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleTypeRepository
 *
 * @author elvea
 */
@Repository
public interface RoleTypeRepository extends CrudRepository<RoleTypeEntity, Long> {
}
