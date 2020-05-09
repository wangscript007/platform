package cn.elvea.platform.core.tag.repository;

import cn.elvea.platform.core.tag.domain.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TagRepository
 *
 * @author elvea
 */
public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
