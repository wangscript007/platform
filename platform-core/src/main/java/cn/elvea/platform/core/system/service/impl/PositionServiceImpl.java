package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.system.domain.PositionEntity;
import cn.elvea.platform.core.system.repository.PositionRepository;
import cn.elvea.platform.core.system.service.PositionService;
import org.springframework.stereotype.Service;

/**
 * PositionService
 *
 * @author elvea
 * @see PositionService
 */
@Service
public class PositionServiceImpl
        extends AbstractService<Long, PositionEntity, PositionRepository>
        implements PositionService {
}
