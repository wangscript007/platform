package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.RoleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleTypeRepository
 *
 * @author elvea
 */
@Repository
public interface RoleTypeRepository extends JpaRepository<RoleTypeEntity, Long> {
}
