package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.RoleEntity;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 *
 * @author elvea
 */
@Repository
public interface RoleRepository extends JdbcRepository<RoleEntity, Long> {
}
