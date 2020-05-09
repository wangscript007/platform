package cn.elvea.platform.core.tag.repository;

import cn.elvea.platform.core.tag.domain.TagTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TagTypeRepository
 *
 * @author elvea
 */
public interface TagTypeRepository extends JpaRepository<TagTypeEntity, Long> {
}
