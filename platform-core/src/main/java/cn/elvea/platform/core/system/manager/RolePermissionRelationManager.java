package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.persistence.jdbc.service.BaseService;
import cn.elvea.platform.core.system.domain.RolePermissionRelationEntity;

/**
 * RolePermissionRelationManager
 *
 * @author elvea
 */
public interface RolePermissionRelationManager
        extends BaseService<RolePermissionRelationEntity, Long> {

    /**
     * 清空缓存
     */
    void clearCache();

}
