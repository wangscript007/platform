package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.service.Manager;
import cn.elvea.platform.core.system.domain.PositionEntity;

/**
 * PositionManager
 *
 * @author elvea
 */
public interface PositionManager extends Manager<PositionEntity, Long> {

    /**
     * 清空缓存
     */
    void clearCache();

}
