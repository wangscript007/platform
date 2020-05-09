package cn.elvea.platform.security;

import cn.elvea.ApplicationBaseWebTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SecurityUtilsTest
 *
 * @author elvea
 */
public class SecurityUtilsTests extends ApplicationBaseWebTests {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityUtilsTests(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    public void encryptPasswordTest() {
        System.out.println(this.passwordEncoder.encode("admin"));
    }

}
