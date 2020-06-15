package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.EntityRelationEntity;
import org.springframework.stereotype.Repository;

/**
 * EntityRelationRepository
 *
 * @author elvea
 */
@Repository
public interface EntityRelationRepository extends JdbcRepository<EntityRelationEntity, Long> {
}
