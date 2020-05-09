package cn.elvea.platform.commons.jpa.utils;

import cn.elvea.platform.commons.jpa.support.Callback;
import cn.elvea.platform.commons.jpa.support.NativeCallback;
import cn.elvea.platform.commons.jpa.support.ReturningCallback;
import cn.elvea.platform.commons.jpa.support.ReturningNativeCallback;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import javax.persistence.EntityManager;

/**
 * JpaUtils
 *
 * @author elvea
 */
public class JpaUtils {

    @Autowired
    EntityManager entityManager;

    /**
     * execute
     *
     * @param callback {@link Callback}
     * @throws DataAccessException DataAccessException
     */
    public void execute(Callback callback) throws DataAccessException {
        callback.execute(entityManager);
    }

    /**
     * execute
     *
     * @param callback {@link ReturningCallback}
     * @param <E>      E
     * @return E
     * @throws DataAccessException DataAccessException
     */
    public <E> E execute(ReturningCallback<E> callback) throws DataAccessException {
        return callback.execute(entityManager);
    }

    /**
     * execute
     *
     * @param callback {@link NativeCallback}
     * @throws DataAccessException DataAccessException
     */
    public void execute(final NativeCallback callback) throws DataAccessException {
        Session session = entityManager.unwrap(Session.class);
        session.doWork(callback::execute);
    }

    /**
     * execute
     *
     * @param callback {@link ReturningNativeCallback}
     * @param <E>      E
     * @return E
     * @throws DataAccessException DataAccessException
     */
    public <E> E execute(final ReturningNativeCallback<E> callback) throws DataAccessException {
        Session session = entityManager.unwrap(Session.class);
        return session.doReturningWork(callback::execute);
    }

}
