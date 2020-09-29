package cn.elvea.platform.core.catalog.manager.impl;

import cn.elvea.platform.commons.service.AbstractManager;
import cn.elvea.platform.core.catalog.domain.CatalogEntity;
import cn.elvea.platform.core.catalog.manager.CatalogManager;
import cn.elvea.platform.core.catalog.repository.CatalogRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import static cn.elvea.platform.core.catalog.CatalogConstants.CACHE_CATALOG;

/**
 * CatalogManager
 *
 * @author elvea
 * @see CatalogManager
 */
@CacheConfig(cacheNames = CACHE_CATALOG)
@Service
public class CatalogManagerImpl
        extends AbstractManager<CatalogEntity, Long, CatalogRepository>
        implements CatalogManager {
}
