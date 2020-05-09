package cn.elvea.platform.core.tag.repository;

import cn.elvea.platform.core.tag.domain.TagRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TagRelationRepository
 *
 * @author elvea
 */
public interface TagRelationRepository extends JpaRepository<TagRelationEntity, Long> {
}
