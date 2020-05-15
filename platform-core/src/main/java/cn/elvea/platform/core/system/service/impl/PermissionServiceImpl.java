package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.jpa.service.AbstractService;
import cn.elvea.platform.core.system.domain.PermissionEntity;
import cn.elvea.platform.core.system.repository.PermissionRepository;
import cn.elvea.platform.core.system.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * PermissionServiceImpl
 *
 * @author elvea
 * @see PermissionService
 */
@Service
public class PermissionServiceImpl extends AbstractService<Long, PermissionEntity, PermissionRepository>
        implements PermissionService {
}
