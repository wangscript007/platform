package cn.elvea.platform.core.tag.repository;

import cn.elvea.platform.core.tag.domain.TagEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * TagRepository
 *
 * @author elvea
 */
public interface TagRepository extends CrudRepository<TagEntity, Long> {
}
