package cn.elvea.platform.core.catalog.repository;

import cn.elvea.platform.core.catalog.domain.CatalogTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CatalogTypeRepository
 *
 * @author elvea
 */
@Repository
public interface CatalogTypeRepository extends CrudRepository<CatalogTypeEntity, Long> {
}
