package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.PositionEntity;
import org.springframework.stereotype.Repository;

/**
 * PositionRepository
 *
 * @author elvea
 */
@Repository
public interface PositionRepository extends JdbcRepository<PositionEntity, Long> {
}
