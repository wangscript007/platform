package cn.elvea.platform.commons.manager;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;

import java.io.Serializable;

/**
 * CompositeManager
 *
 * @param <T>
 * @param <K>
 */
public interface CompositeManager<T extends BaseEntity, K extends Serializable> extends Manager<T, K> {
}
