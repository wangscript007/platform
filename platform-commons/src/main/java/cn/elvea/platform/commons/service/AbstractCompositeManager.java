package cn.elvea.platform.commons.service;

import cn.elvea.platform.commons.domain.IdEntity;
import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * AbstractCompositeManager
 *
 * @author elvea
 */
public abstract class AbstractCompositeManager<T extends IdEntity, K extends Serializable, R extends JdbcRepository<T, K>, M>
        extends AbstractManager<T, K, R>
        implements Manager<T, K> {

    @Autowired
    protected M mapper;

}
