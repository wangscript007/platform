package cn.elvea.platform.core.i18n.repository;

import cn.elvea.platform.core.i18n.domain.LangLabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * LangLabelRepository
 *
 * @author elvea
 */
@Repository
public interface LangLabelRepository extends JpaRepository<LangLabelEntity, Long> {
}
