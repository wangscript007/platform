package cn.elvea.platform.core.system.service;

import cn.elvea.platform.commons.jpa.service.AbstractBaseService;
import cn.elvea.platform.commons.utils.ConvertUtils;
import cn.elvea.platform.core.system.domain.RoleEntity;
import cn.elvea.platform.core.system.dto.RoleTypeDto;
import cn.elvea.platform.core.system.repository.RoleRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * RoleServiceImpl
 *
 * @author elvea
 * @see RoleService
 */
@Service
public class RoleServiceImpl
        extends AbstractBaseService<RoleRepository, RoleEntity, Long>
        implements RoleService {

    @Override
    public RoleTypeDto findRoleTypeByCode(String code) {
        RoleEntity condition = new RoleEntity(code);
        RoleEntity entity = this.repository.findOne(Example.of(condition)).orElseThrow();
        return ConvertUtils.convert(entity, RoleTypeDto.class);
    }

}
