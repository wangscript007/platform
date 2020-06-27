package cn.elvea.platform.core.catalog.manager.impl;

import cn.elvea.platform.commons.persistence.jdbc.service.AbstractService;
import cn.elvea.platform.core.catalog.domain.CatalogEntity;
import cn.elvea.platform.core.catalog.manager.CatalogManager;
import cn.elvea.platform.core.catalog.repository.CatalogRepository;
import org.springframework.cache.annotation.CacheConfig;

import static cn.elvea.platform.core.catalog.CatalogConstants.CACHE_CATALOG;

/**
 * CatalogManager
 *
 * @author elvea
 * @see CatalogManager
 */
@CacheConfig(cacheNames = CACHE_CATALOG)
public class CatalogManagerImpl
        extends AbstractService<CatalogEntity, Long, CatalogRepository>
        implements CatalogManager {
}
