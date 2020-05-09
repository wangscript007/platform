package cn.elvea.platform.commons.context;

import cn.elvea.ApplicationBaseWebTests;
import cn.elvea.platform.commons.Context;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ContextTests
 *
 * @author elvea
 */
public class ContextTests extends ApplicationBaseWebTests {

    @Autowired
    private Context context;

    @Test
    public void test() {
        Assertions.assertNotNull(context);
    }

}
