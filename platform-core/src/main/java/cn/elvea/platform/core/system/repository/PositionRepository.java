package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PositionRepository
 *
 * @author elvea
 */
@Repository
public interface PositionRepository
        extends JpaRepository<PositionEntity, Long> {
}
