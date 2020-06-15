package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.system.domain.UserSessionTokenHistoryEntity;
import org.springframework.stereotype.Repository;

/**
 * UserSessionTokenHistoryRepository
 *
 * @author elvea
 */
@Repository
public interface UserSessionTokenHistoryRepository extends JdbcRepository<UserSessionTokenHistoryEntity, Long> {
}
