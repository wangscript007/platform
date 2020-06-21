package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.persistence.jdbc.service.BaseService;
import cn.elvea.platform.core.system.domain.RoleEntity;

/**
 * RoleManager
 *
 * @author elvea
 */
public interface RoleManager extends BaseService<RoleEntity, Long> {

    /**
     * 清空缓存
     */
    void clearCache();

}
