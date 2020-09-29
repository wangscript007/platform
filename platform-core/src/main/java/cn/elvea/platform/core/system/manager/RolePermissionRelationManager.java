package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.service.Manager;
import cn.elvea.platform.core.system.domain.RolePermissionRelationEntity;

/**
 * RolePermissionRelationManager
 *
 * @author elvea
 */
public interface RolePermissionRelationManager
        extends Manager<RolePermissionRelationEntity, Long> {

    /**
     * 清空缓存
     */
    void clearCache();

}
