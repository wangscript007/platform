package cn.elvea.platform.core.system.service;

import cn.elvea.platform.commons.jpa.service.AbstractBaseService;
import cn.elvea.platform.core.system.domain.PermissionEntity;
import cn.elvea.platform.core.system.repository.PermissionRepository;
import org.springframework.stereotype.Service;

/**
 * PermissionServiceImpl
 *
 * @author elvea
 * @see PermissionService
 */
@Service
public class PermissionServiceImpl
        extends AbstractBaseService<PermissionRepository, PermissionEntity, Long>
        implements PermissionService {
}
