package cn.elvea.platform.commons.jpa.support;

import org.springframework.dao.DataAccessException;

import javax.persistence.EntityManager;

/**
 * ReturningCallback
 *
 * @author elvea
 */
public interface ReturningCallback<T> {
    T execute(EntityManager entityManager) throws DataAccessException;
}
