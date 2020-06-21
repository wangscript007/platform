package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.persistence.jdbc.service.BaseService;
import cn.elvea.platform.core.system.domain.UserRoleRelationEntity;

/**
 * UserRoleRelationManager
 *
 * @author elvea
 */
public interface UserRoleRelationManager
        extends BaseService<UserRoleRelationEntity, Long> {
    /**
     * 清空缓存
     */
    void clearCache();
}
