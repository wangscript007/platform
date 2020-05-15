package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.jpa.service.AbstractService;
import cn.elvea.platform.core.system.domain.DepartmentEntity;
import cn.elvea.platform.core.system.repository.DepartmentRepository;
import cn.elvea.platform.core.system.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * DepartmentService
 *
 * @author elvea
 * @see DepartmentService
 */
@Service
public class DepartmentServiceImpl extends AbstractService<Long, DepartmentEntity, DepartmentRepository>
        implements DepartmentService {
}
