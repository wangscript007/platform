package cn.elvea.platform.commons.manager;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;

import java.io.Serializable;

/**
 * Manager
 *
 * @param <T>
 * @param <K>
 */
public interface Manager<T extends BaseEntity, K extends Serializable> {

    /**
     * 根据ID查询唯一记录
     *
     * @param id ID
     * @return T
     */
    T findById(K id);

}
