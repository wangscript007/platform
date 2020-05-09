package cn.elvea.platform.commons.jpa.support;

import org.springframework.dao.DataAccessException;

import javax.persistence.EntityManager;

/**
 * Callback
 *
 * @author elvea
 */
public interface Callback {
    void execute(EntityManager entityManager) throws DataAccessException;
}
