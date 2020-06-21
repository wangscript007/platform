package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.persistence.jdbc.service.BaseService;
import cn.elvea.platform.core.system.domain.PositionEntity;

/**
 * PositionManager
 *
 * @author elvea
 */
public interface PositionManager extends BaseService<PositionEntity, Long> {

    /**
     * 清空缓存
     */
    void clearCache();

}
