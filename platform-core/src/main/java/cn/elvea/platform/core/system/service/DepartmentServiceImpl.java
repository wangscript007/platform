package cn.elvea.platform.core.system.service;

import cn.elvea.platform.commons.jpa.service.AbstractBaseService;
import cn.elvea.platform.core.system.domain.DepartmentEntity;
import cn.elvea.platform.core.system.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

/**
 * DepartmentServiceImpl
 *
 * @author elvea
 * @see DepartmentService
 */
@Service
public class DepartmentServiceImpl
        extends AbstractBaseService<DepartmentRepository, DepartmentEntity, Long>
        implements DepartmentService {
}
