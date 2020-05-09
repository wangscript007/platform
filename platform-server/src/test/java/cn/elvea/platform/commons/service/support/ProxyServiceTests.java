package cn.elvea.platform.commons.service.support;

import cn.elvea.ApplicationBaseWebTests;
import cn.elvea.platform.commons.Context;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ProxyServiceTests
 *
 * @author elvea
 */
public class ProxyServiceTests extends ApplicationBaseWebTests {

    @Autowired
    Context context;

    @Autowired
    TestProxyService testProxyService;

    @Test
    public void test() {
        TestProxyService service = this.testProxyService.getInstance();
        System.out.println(service);
        System.out.println(this.testProxyService);
        Assertions.assertNotNull(service);
    }

}
