package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 *
 * @author elvea
 */
@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
