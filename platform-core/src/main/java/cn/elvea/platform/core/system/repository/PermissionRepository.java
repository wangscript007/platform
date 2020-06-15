package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.PermissionEntity;
import org.springframework.stereotype.Repository;

/**
 * PermissionRepository
 *
 * @author elvea
 */
@Repository
public interface PermissionRepository extends JdbcRepository<PermissionEntity, Long> {
}
