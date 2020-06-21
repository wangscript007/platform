package cn.elvea.platform.core.system.mapper;

import cn.elvea.ApplicationBaseTests;
import cn.elvea.platform.commons.utils.CollectionUtils;
import cn.elvea.platform.core.system.domain.EntityRelationEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * EntityRelationMapperTests
 *
 * @author elvea
 */
public class EntityRelationMapperTests extends ApplicationBaseTests {

    @Autowired
    EntityRelationMapper entityRelationMapper;

    @Test
    public void test() {
        Assertions.assertNotNull(this.entityRelationMapper);

        Pageable pageable = PageRequest.of(1, 1);
        List<EntityRelationEntity> list = this.entityRelationMapper.search(pageable);
        Assertions.assertTrue(CollectionUtils.isNotEmpty(list));
    }

}
