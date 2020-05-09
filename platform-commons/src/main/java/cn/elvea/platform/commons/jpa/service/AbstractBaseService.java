package cn.elvea.platform.commons.jpa.service;

import cn.elvea.platform.commons.domain.IdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * AbstractBaseService
 *
 * @author elvea
 */
public abstract class AbstractBaseService<R extends JpaRepository<T, PK>, T extends IdEntity, PK extends Serializable> {

    @Autowired
    protected R repository;

    public T insert(T entity) {
        return save(entity);
    }

    public T updateById(T entity) {
        return save(entity);
    }

    public T save(T entity) {
        return this.repository.saveAndFlush(entity);
    }

    public void deleteById(PK id) {
        this.repository.deleteById(id);
    }

    public T findOneById(PK id) {
        return this.repository.getOne(id);
    }

    public T findOne(T condition) {
        return this.repository.findOne(null).get();
    }

    public List<T> findAll() {
        return this.repository.findAll();
    }

    public Page<T> findByPage(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

}
