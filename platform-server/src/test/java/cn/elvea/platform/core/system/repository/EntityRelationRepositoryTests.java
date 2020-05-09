package cn.elvea.platform.core.system.repository;

import cn.elvea.ApplicationBaseWebTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * EntityRelationRepositoryTests
 *
 * @author elvea
 */
public class EntityRelationRepositoryTests extends ApplicationBaseWebTests {

    private final EntityRelationRepository entityRelationRepository;

    @Autowired
    public EntityRelationRepositoryTests(EntityRelationRepository entityRelationRepository) {
        this.entityRelationRepository = entityRelationRepository;
    }

    @Test
    public void test() {
        Assertions.assertNotNull(this.entityRelationRepository);
    }

}
