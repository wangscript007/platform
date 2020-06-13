package cn.elvea.platform.core.catalog.repository;

import cn.elvea.platform.commons.persistence.jdbc.repository.JdbcRepository;
import cn.elvea.platform.core.catalog.domain.CatalogEntity;
import org.springframework.stereotype.Repository;

/**
 * CatalogRepository
 *
 * @author elvea
 */
@Repository
public interface CatalogRepository extends JdbcRepository<CatalogEntity, Long> {
}
