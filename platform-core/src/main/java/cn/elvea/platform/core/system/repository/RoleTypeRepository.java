package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.RoleTypeEntity;
import org.springframework.stereotype.Repository;

/**
 * RoleTypeRepository
 *
 * @author elvea
 */
@Repository
public interface RoleTypeRepository extends JdbcRepository<RoleTypeEntity, Long> {
}
