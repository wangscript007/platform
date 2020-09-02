package cn.elvea.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.crypto.keys.KeyManager;
import org.springframework.security.crypto.keys.StaticKeyGeneratingKeyManager;

/**
 * 认证服务器配置
 * <p>
 * <a href="https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/html5/">OAuth2 Boot</a>
 *
 * @author elvea
 */
@Configuration
@Import(OAuth2AuthorizationServerConfiguration.class)
public class AuthorizationServerConfig {
    
    @Bean
    public KeyManager keyManager() {
        return new StaticKeyGeneratingKeyManager();
    }

}
