package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.UserSessionTokenHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserSessionTokenHistoryRepository
 *
 * @author elvea
 */
@Repository
public interface UserSessionTokenHistoryRepository extends JpaRepository<UserSessionTokenHistoryEntity, Long> {
}
