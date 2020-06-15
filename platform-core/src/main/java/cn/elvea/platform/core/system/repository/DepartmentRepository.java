package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.DepartmentEntity;
import org.springframework.stereotype.Repository;

/**
 * DepartmentRepository
 *
 * @author elvea
 */
@Repository
public interface DepartmentRepository extends JdbcRepository<DepartmentEntity, Long> {
}
