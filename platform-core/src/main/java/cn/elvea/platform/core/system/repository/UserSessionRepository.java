package cn.elvea.platform.core.system.repository;

import cn.elvea.platform.core.system.domain.UserSessionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserSessionRepository
 *
 * @author elvea
 */
@Repository
public interface UserSessionRepository extends CrudRepository<UserSessionEntity, Long> {
}
