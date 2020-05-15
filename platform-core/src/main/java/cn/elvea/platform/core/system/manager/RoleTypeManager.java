package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.core.system.domain.RoleTypeEntity;

/**
 * RoleTypeManager
 *
 * @author elvea
 */
public interface RoleTypeManager {

    RoleTypeEntity findOneByCode(String code);

}
