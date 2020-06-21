package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.persistence.jdbc.service.BaseService;
import cn.elvea.platform.core.system.domain.RoleTypeEntity;

/**
 * RoleTypeManager
 *
 * @author elvea
 */
public interface RoleTypeManager extends BaseService<RoleTypeEntity, Long> {

    /**
     * 根据编号查找角色类型
     *
     * @param code 编号
     * @return RoleTypeEntity
     */
    RoleTypeEntity findByCode(String code);

    /**
     * 清空缓存
     */
    void clearCache();

}
