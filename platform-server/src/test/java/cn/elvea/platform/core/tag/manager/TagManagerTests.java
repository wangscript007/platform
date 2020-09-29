package cn.elvea.platform.core.tag.manager;

import cn.elvea.ApplicationBaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TagManagerTests
 *
 * @author elvea
 */
public class TagManagerTests extends ApplicationBaseTests {

    @Autowired
    private TagManager tagManager;

    @Test
    public void test() {
        Assertions.assertNotNull(tagManager);
    }

}
