package cn.elvea.platform.commons.jpa.id;

import cn.elvea.platform.commons.sequence.IdWorker;
import cn.elvea.platform.commons.utils.SpringContextUtils;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

/**
 * IdGenerator
 *
 * @author elvea
 */
public class IdGenerator implements IdentifierGenerator, Configurable {

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        IdWorker idWorker = SpringContextUtils.getBean(IdWorker.class);
        return idWorker.nextId();
    }

}
