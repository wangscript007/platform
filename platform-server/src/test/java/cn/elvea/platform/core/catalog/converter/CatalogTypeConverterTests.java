package cn.elvea.platform.core.catalog.converter;

import cn.elvea.platform.core.catalog.domain.CatalogTypeEntity;
import cn.elvea.platform.core.catalog.dto.CatalogTypeDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * CatalogTypeConverterTests
 *
 * @author elvea
 */
public class CatalogTypeConverterTests {

    @Test
    public void test() {
        CatalogTypeEntity entity = new CatalogTypeEntity();
        entity.setId(1L);
        entity.setCode("CAT001");
        CatalogTypeDto dto = CatalogTypeConverter.INSTANCE.entityToDto(entity);
        assertNotNull(dto);
    }

}
