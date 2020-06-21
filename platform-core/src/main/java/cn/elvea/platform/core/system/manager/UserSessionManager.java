package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.persistence.jdbc.service.BaseService;
import cn.elvea.platform.core.system.domain.UserSessionEntity;

/**
 * UserSessionManager
 *
 * @author elvea
 */
public interface UserSessionManager extends BaseService<UserSessionEntity, Long> {

    /**
     * 清空缓存
     */
    void clearCache();

}
