package cn.elvea.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

/**
 * OAuth
 *
 * @author elvea
 */
@Configuration
public class OAuthCommonConfig {

    @Bean
    public KeyPair keyPair() {
        KeyStoreKeyFactory keyStoreKeyFactory =
                new KeyStoreKeyFactory(new ClassPathResource("jwt/jwt.jks"), "jwttest".toCharArray());
        return keyStoreKeyFactory.getKeyPair("jwttest");
    }

    @Bean
    public JwtDecoder jwtDecoder(KeyPair keyPair) {
        return NimbusJwtDecoder.withPublicKey((RSAPublicKey) keyPair.getPublic()).build();
    }

}
