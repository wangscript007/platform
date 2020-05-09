package cn.elvea.platform.commons.utils;

import cn.elvea.platform.commons.service.support.ProxyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * GenericsUtilsTests
 *
 * @author elvea
 */
public class GenericsUtilsTests {

    @Test
    public void test() {
        Class<?> clazz01 = GenericsUtils.getSuperGenericType(TestService.class, BaseService.class, 0);
        Class<?> clazz02 = GenericsUtils.getSuperGenericType(TestService.class, BaseService.class, 1);
        Assertions.assertEquals(clazz01, Long.class);
        Assertions.assertEquals(clazz02, String.class);
        Class<?> clazz03 = GenericsUtils.getSuperGenericType(TestService.class, AbstractService.class, 0);
        Class<?> clazz04 = GenericsUtils.getSuperGenericType(TestService.class, AbstractService.class, 1);
        Assertions.assertEquals(clazz03, Long.class);
        Assertions.assertEquals(clazz04, String.class);
        Class<?> clazz05 = GenericsUtils.getSuperGenericType(TestService.class, ProxyService.class, 0);
        Assertions.assertEquals(clazz05, TestService.class);
        Class<?> clazz06 = GenericsUtils.getSuperGenericType(TestService.class, 0);
        Class<?> clazz07 = GenericsUtils.getSuperGenericType(TestService.class, 1);
        Assertions.assertEquals(clazz06, Long.class);
        Assertions.assertEquals(clazz07, String.class);

        Class<?> clazz11 = GenericsUtils.getSuperInterfacesGenericType(TestService.class, BaseService.class, 0);
        Class<?> clazz12 = GenericsUtils.getSuperInterfacesGenericType(TestService.class, BaseService.class, 1);
        Assertions.assertEquals(clazz11, Long.class);
        Assertions.assertEquals(clazz12, String.class);
        Class<?> clazz13 = GenericsUtils.getSuperInterfacesGenericType(TestService.class, ProxyService.class, 0);
        Assertions.assertEquals(clazz13, TestService.class);
        Class<?> clazz14 = GenericsUtils.getSuperClassGenericType(TestService.class, 0);
        Class<?> clazz15 = GenericsUtils.getSuperClassGenericType(TestService.class, 1);
        Assertions.assertEquals(clazz14, Long.class);
        Assertions.assertEquals(clazz15, String.class);
    }

    interface BaseService<T, K> {
    }

    static abstract class AbstractService<T, K> {
    }

    static class TestService
            extends AbstractService<Long, String>
            implements ProxyService<TestService>, BaseService<Long, String> {
    }

}
