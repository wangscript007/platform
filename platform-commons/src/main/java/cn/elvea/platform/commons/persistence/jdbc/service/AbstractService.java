package cn.elvea.platform.commons.persistence.jdbc.service;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * AbstractService
 *
 * @param <K> 主键类型
 * @param <T> 实体类型
 * @param <R> 仓库类型
 * @see BaseService
 */
public abstract class AbstractService<T extends BaseEntity, K extends Serializable, R extends PagingAndSortingRepository<T, K>>
        implements BaseService<T, K> {

    @Autowired
    protected R repository;

    /**
     * @see BaseService#findById(Serializable)
     */
    @Override
    public T findById(K id) {
        return this.findOneById(id).orElse(null);
    }

    /**
     * @see BaseService#findOneById(Serializable)
     */
    @Override
    public Optional<T> findOneById(K id) {
        return this.repository.findById(id);
    }

    /**
     * @see BaseService#findAllById(Iterable)
     */
    @Override
    public List<T> findAllById(Iterable<K> ids) {
        return Lists.newArrayList(this.repository.findAllById(ids).iterator());
    }

    /**
     * @see BaseService#findAll()
     */
    @Override
    public List<T> findAll() {
        return Lists.newArrayList(this.repository.findAll().iterator());
    }

    /**
     * @see BaseService#deleteById(Serializable)
     */
    @Override
    public void deleteById(K id) {
        this.repository.deleteById(id);
    }

    /**
     * @see BaseService#delete(T)
     */
    @Override
    public void delete(T entity) {
        this.repository.delete(entity);
    }

    /**
     * @see BaseService#deleteInBatch(Iterable)
     */
    @Override
    public void deleteInBatch(Iterable<T> entities) {
        this.repository.deleteAll(entities);
    }

    /**
     * @see BaseService#deleteAll(Iterable)
     */
    @Override
    public void deleteAll(Iterable<T> entities) {
        this.repository.deleteAll(entities);
    }

    /**
     * @see BaseService#save(T)
     */
    @Override
    public void save(T entity) {
        this.repository.save(entity);
    }

    /**
     * @see BaseService#saveAndFlush(T)
     */
    @Override
    public void saveAndFlush(T entity) {
        this.repository.save(entity);
    }

    /**
     * @see BaseService#saveAll(Iterable)
     */
    @Override
    public void saveAll(Iterable<T> entities) {
        this.repository.saveAll(entities);
    }

}
