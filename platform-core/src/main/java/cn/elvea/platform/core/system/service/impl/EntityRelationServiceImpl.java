package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.jpa.service.AbstractService;
import cn.elvea.platform.core.system.domain.EntityRelationEntity;
import cn.elvea.platform.core.system.repository.EntityRelationRepository;
import cn.elvea.platform.core.system.service.EntityRelationService;
import org.springframework.stereotype.Service;

/**
 * EntityRelationServiceImpl
 *
 * @author elvea
 * @see EntityRelationService
 */
@Service
public class EntityRelationServiceImpl extends AbstractService<Long, EntityRelationEntity, EntityRelationRepository>
        implements EntityRelationService {
}
