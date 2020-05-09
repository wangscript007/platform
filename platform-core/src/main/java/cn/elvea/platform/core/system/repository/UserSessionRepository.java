package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.UserSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserSessionRepository
 *
 * @author elvea
 */
@Repository
public interface UserSessionRepository
        extends JpaRepository<UserSessionEntity, Long> {
}
