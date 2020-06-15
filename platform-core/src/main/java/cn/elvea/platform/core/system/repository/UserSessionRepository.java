package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.UserSessionEntity;
import org.springframework.stereotype.Repository;

/**
 * UserSessionRepository
 *
 * @author elvea
 */
@Repository
public interface UserSessionRepository extends JdbcRepository<UserSessionEntity, Long> {
}
