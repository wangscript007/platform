package cn.elvea.platform.core.catalog.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.catalog.domain.CatalogTypeEntity;
import org.springframework.stereotype.Repository;

/**
 * CatalogTypeRepository
 *
 * @author elvea
 */
@Repository
public interface CatalogTypeRepository extends JdbcRepository<CatalogTypeEntity, Long> {
}
