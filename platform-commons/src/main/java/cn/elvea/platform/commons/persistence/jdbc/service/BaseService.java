package cn.elvea.platform.commons.persistence.jdbc.service;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * BaseService
 *
 * @param <T> 实体类型
 * @param <K> 主键类型
 * @author elvea
 */
public interface BaseService<T extends BaseEntity, K extends Serializable> {

    /**
     * 根据ID查询唯一记录
     *
     * @param id ID
     * @return T
     */
    T findById(K id);

    /**
     * 根据ID查询唯一记录
     *
     * @param id ID
     * @return T
     */
    Optional<T> findOneById(K id);

    /**
     * 查询多条记录
     *
     * @param ids ID
     * @return List
     */
    List<T> findAllById(Iterable<K> ids);

    /**
     * 查询多条记录
     *
     * @return List
     */
    List<T> findAll();

    /**
     * 根据ID删除唯一记录
     *
     * @param id ID
     */
    void deleteById(K id);

    /**
     * 删除实体
     *
     * @param entity T
     */
    void delete(T entity);

    /**
     * 批量删除实体
     *
     * @param entities 待删除实体
     */
    void deleteAll(Iterable<T> entities);

    /**
     * 批量删除实体
     *
     * @param entities 待删除实体
     */
    void deleteInBatch(Iterable<T> entities);

    /**
     * 保存实体
     *
     * @param entity T
     */
    T save(T entity);

    /**
     * 批量保存实体
     *
     * @param entities 待保存实体
     */
    void saveAll(Iterable<T> entities);
}
