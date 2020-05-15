package cn.elvea.platform.core.i18n.repository;

import cn.elvea.platform.core.i18n.domain.LangTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LangTypeRepository
 *
 * @author elvea
 */
public interface LangTypeRepository extends JpaRepository<LangTypeEntity, Long> {
}
