package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.EntityRelationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * EntityRelationRepository
 *
 * @author elvea
 */
@Repository
public interface EntityRelationRepository extends CrudRepository<EntityRelationEntity, Long> {
}
