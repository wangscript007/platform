package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PermissionRepository
 *
 * @author elvea
 */
@Repository
public interface PermissionRepository
        extends JpaRepository<PermissionEntity, Long> {
}
