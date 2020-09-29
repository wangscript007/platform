package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.service.Manager;
import cn.elvea.platform.core.system.domain.RoleEntity;

/**
 * RoleManager
 *
 * @author elvea
 */
public interface RoleManager extends Manager<RoleEntity, Long> {

    /**
     * 清空缓存
     */
    void clearCache();

}
