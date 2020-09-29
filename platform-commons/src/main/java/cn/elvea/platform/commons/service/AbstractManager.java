package cn.elvea.platform.commons.service;

import cn.elvea.platform.commons.domain.IdEntity;
import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * AbstractManager
 *
 * @param <T> 实体
 * @param <K> 主键
 * @param <R> Repository
 */
public abstract class AbstractManager<T extends IdEntity, K extends Serializable, R extends JdbcRepository<T, K>>
        implements Manager<T, K> {

    @Autowired
    protected R repository;

    /**
     * @see Manager#findById(Serializable)
     */
    @Override
    public T findById(K id) {
        return this.repository.findById(id).orElse(null);
    }

    /**
     * @see Manager#findByIds(Iterable)
     */
    @Override
    public Iterable<T> findByIds(Iterable<K> ids) {
        return this.repository.findAllById(ids);
    }

    /**
     * @see Manager#findAll()
     */
    @Override
    public Iterable<T> findAll() {
        return this.repository.findAll();
    }

    /**
     * @see Manager#findAll(Sort)
     */
    @Override
    public Iterable<T> findAll(Sort sort) {
        return this.repository.findAll(sort);
    }

    /**
     * @see Manager#findAll(Pageable)
     */
    @Override
    public Iterable<T> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    /**
     * @see Manager#save(IdEntity)
     */
    @Override
    public T save(T entity) {
        return this.repository.save(entity);
    }

    /**
     * @see Manager#save(Iterable)
     */
    @Override
    public Iterable<T> save(Iterable<T> entities) {
        return this.repository.saveAll(entities);
    }

    /**
     * @see Manager#delete(IdEntity)
     */
    @Override
    public void delete(T entity) {
        this.repository.delete(entity);
    }

    /**
     * @see Manager#deleteById(Serializable)
     */
    @Override
    public void deleteById(K id) {
        this.repository.deleteById(id);
    }

    /**
     * @see Manager#deleteAll(Iterable)
     */
    @Override
    public void deleteAll(Iterable<T> entities) {
        this.repository.deleteAll(entities);
    }

    /**
     * @see Manager#deleteAll()
     */
    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }

    /**
     * @see Manager#count()
     */
    @Override
    public void count() {
        this.repository.count();
    }

    /**
     * @see Manager#existsById(Serializable)
     */
    @Override
    public boolean existsById(K id) {
        return this.repository.existsById(id);
    }

}
