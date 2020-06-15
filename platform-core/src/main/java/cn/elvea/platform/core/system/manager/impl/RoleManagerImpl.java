package cn.elvea.platform.core.system.manager.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.system.domain.RoleEntity;
import cn.elvea.platform.core.system.manager.RoleManager;
import cn.elvea.platform.core.system.repository.RoleRepository;
import org.springframework.stereotype.Service;

/**
 * RoleManager
 *
 * @author elvea
 * @see RoleManager
 */
@Service
public class RoleManagerImpl
        extends AbstractService<RoleEntity, Long, RoleRepository>
        implements RoleManager {
}
