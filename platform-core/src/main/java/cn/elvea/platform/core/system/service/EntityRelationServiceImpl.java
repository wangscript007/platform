package cn.elvea.platform.core.system.service;

import cn.elvea.platform.commons.jpa.service.AbstractBaseService;
import cn.elvea.platform.core.system.domain.EntityRelationEntity;
import cn.elvea.platform.core.system.repository.EntityRelationRepository;
import org.springframework.stereotype.Service;

/**
 * EntityRelationServiceImpl
 *
 * @author elvea
 * @see EntityRelationService
 */
@Service
public class EntityRelationServiceImpl
        extends AbstractBaseService<EntityRelationRepository, EntityRelationEntity, Long>
        implements EntityRelationService {
}
