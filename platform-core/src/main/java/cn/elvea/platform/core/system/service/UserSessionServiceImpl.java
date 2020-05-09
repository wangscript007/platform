package cn.elvea.platform.core.system.service;

import cn.elvea.platform.commons.jpa.service.AbstractBaseService;
import cn.elvea.platform.core.system.domain.UserSessionEntity;
import cn.elvea.platform.core.system.repository.UserSessionRepository;
import org.springframework.stereotype.Service;

/**
 * UserSessionServiceImpl
 *
 * @author elvea
 * @see UserSessionService
 */
@Service
public class UserSessionServiceImpl
        extends AbstractBaseService<UserSessionRepository, UserSessionEntity, Long>
        implements UserSessionService {
}
