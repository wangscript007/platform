package cn.elvea.platform.core.system.service;

import cn.elvea.platform.commons.jpa.service.AbstractBaseService;
import cn.elvea.platform.core.system.domain.PositionEntity;
import cn.elvea.platform.core.system.repository.PositionRepository;
import org.springframework.stereotype.Service;

/**
 * PositionServiceImpl
 *
 * @author elvea
 * @see PositionService
 */
@Service
public class PositionServiceImpl
        extends AbstractBaseService<PositionRepository, PositionEntity, Long>
        implements PositionService {
}
