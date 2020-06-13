package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.core.system.domain.RoleTypeEntity;

/**
 * RoleTypeManager
 *
 * @author elvea
 */
public interface RoleTypeManager {

    /**
     * @param code 编号
     * @return RoleTypeEntity
     */
    RoleTypeEntity findByCode(String code);

}
