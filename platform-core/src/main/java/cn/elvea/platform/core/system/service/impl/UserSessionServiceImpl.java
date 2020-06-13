package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.system.domain.UserSessionEntity;
import cn.elvea.platform.core.system.repository.UserSessionRepository;
import cn.elvea.platform.core.system.service.UserSessionService;
import org.springframework.stereotype.Service;

/**
 * UserSessionServiceImpl
 *
 * @author elvea
 * @see UserSessionService
 */
@Service
public class UserSessionServiceImpl
        extends AbstractService<Long, UserSessionEntity, UserSessionRepository>
        implements UserSessionService {
}
