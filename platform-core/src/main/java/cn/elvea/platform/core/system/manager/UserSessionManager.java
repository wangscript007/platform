package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.service.Manager;
import cn.elvea.platform.core.system.domain.UserSessionEntity;

/**
 * UserSessionManager
 *
 * @author elvea
 */
public interface UserSessionManager extends Manager<UserSessionEntity, Long> {

    /**
     * 清空缓存
     */
    void clearCache();

}
