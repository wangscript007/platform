package cn.elvea.platform.core.tag.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.tag.domain.TagEntity;

/**
 * TagRepository
 *
 * @author elvea
 */
public interface TagRepository extends JdbcRepository<TagEntity, Long> {
}
