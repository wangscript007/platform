package cn.elvea.platform.core.catalog.manager.impl;

import cn.elvea.platform.commons.service.AbstractManager;
import cn.elvea.platform.core.catalog.domain.CatalogTypeEntity;
import cn.elvea.platform.core.catalog.manager.CatalogTypeManager;
import cn.elvea.platform.core.catalog.repository.CatalogTypeRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import static cn.elvea.platform.core.catalog.CatalogConstants.CACHE_CATALOG_TYPE;

/**
 * CatalogTypeManager
 *
 * @author elvea
 * @see CatalogTypeManager
 */
@CacheConfig(cacheNames = CACHE_CATALOG_TYPE)
@Service
public class CatalogTypeManagerImpl
        extends AbstractManager<CatalogTypeEntity, Long, CatalogTypeRepository>
        implements CatalogTypeManager {
}
