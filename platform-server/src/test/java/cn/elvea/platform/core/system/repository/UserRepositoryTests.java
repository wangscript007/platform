package cn.elvea.platform.core.system.repository;

import cn.elvea.ApplicationBaseWebTests;
import cn.elvea.platform.core.system.domain.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserRepositoryTests
 *
 * @author elvea
 */
public class UserRepositoryTests extends ApplicationBaseWebTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        Assertions.assertNotNull(this.userRepository);
    }

    @Test
    public void testFindByUsername() {
        UserEntity userEntity = this.userRepository.findByUsername("admin");
        Assertions.assertNotNull(userEntity);
    }

}
