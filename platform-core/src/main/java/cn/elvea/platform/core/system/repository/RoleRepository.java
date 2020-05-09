package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 *
 * @author elvea
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
