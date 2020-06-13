package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * DepartmentRepository
 *
 * @author elvea
 */
@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Long> {
}
