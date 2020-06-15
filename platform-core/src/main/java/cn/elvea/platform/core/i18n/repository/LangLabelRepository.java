package cn.elvea.platform.core.i18n.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.i18n.domain.LangLabelEntity;
import org.springframework.stereotype.Repository;

/**
 * LangLabelRepository
 *
 * @author elvea
 */
@Repository
public interface LangLabelRepository extends JdbcRepository<LangLabelEntity, Long> {
}
