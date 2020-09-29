package cn.elvea.platform.core.tag.manager;

import cn.elvea.platform.commons.service.AbstractCompositeManager;
import cn.elvea.platform.core.tag.domain.TagEntity;
import cn.elvea.platform.core.tag.mapper.TagMapper;
import cn.elvea.platform.core.tag.repository.TagRepository;
import org.springframework.stereotype.Service;

/**
 * TagManagerImpl
 *
 * @author elvea
 * @see cn.elvea.platform.core.tag.manager.TagManager
 */
@Service
public class TagManagerImpl
        extends AbstractCompositeManager<TagEntity, Long, TagRepository, TagMapper>
        implements TagManager {
}
