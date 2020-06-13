package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.system.domain.RoleEntity;
import cn.elvea.platform.core.system.repository.RoleRepository;
import cn.elvea.platform.core.system.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * RoleService
 *
 * @author elvea
 * @see RoleService
 */
@Service
public class RoleServiceImpl
        extends AbstractService<Long, RoleEntity, RoleRepository>
        implements RoleService {
}
