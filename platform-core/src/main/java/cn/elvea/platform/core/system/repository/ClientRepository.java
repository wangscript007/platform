package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.ClientEntity;
import org.springframework.stereotype.Repository;

/**
 * ClientRepository
 *
 * @author elvea
 */
@Repository
public interface ClientRepository extends JdbcRepository<ClientEntity, Long> {

    /**
     * 根据标识查找用户
     */
    ClientEntity findByClientId(String clientId);

}
