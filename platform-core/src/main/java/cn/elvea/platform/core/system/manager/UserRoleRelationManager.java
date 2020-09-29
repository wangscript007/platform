package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.service.Manager;
import cn.elvea.platform.core.system.domain.UserRoleRelationEntity;

/**
 * UserRoleRelationManager
 *
 * @author elvea
 */
public interface UserRoleRelationManager extends Manager<UserRoleRelationEntity, Long> {
    /**
     * 清空缓存
     */
    void clearCache();
}
