package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.service.Manager;
import cn.elvea.platform.core.system.domain.PermissionEntity;

/**
 * PermissionManager
 *
 * @author elvea
 */
public interface PermissionManager extends Manager<PermissionEntity, Long> {

    /**
     * 清空缓存
     */
    void clearCache();

}
