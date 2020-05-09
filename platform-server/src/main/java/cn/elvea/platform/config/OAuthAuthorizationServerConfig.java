package cn.elvea.platform.config;

import cn.elvea.platform.security.service.SecurityClientDetailsService;
import cn.elvea.platform.security.support.SubjectAttributeUserTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;
import java.security.KeyPair;

/**
 * 认证服务器配置
 *
 * @author elvea
 */
@Order
@Configuration
@EnableAuthorizationServer
public class OAuthAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final DataSource dataSource;

    private final AuthenticationManager authenticationManager;

    private final KeyPair keyPair;

    @Autowired
    public OAuthAuthorizationServerConfig(
            AuthenticationConfiguration authenticationConfiguration,
            KeyPair keyPair,
            DataSource dataSource
    ) throws Exception {
        this.dataSource = dataSource;
        this.keyPair = keyPair;
        this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(this.authenticationManager);
        endpoints.tokenStore(tokenStore());
        endpoints.accessTokenConverter(accessTokenConverter());
        // 默认情况下，只有第一次请求到的Refresh Token可用，
        // 后续刷新后获取到的Refresh Token都无法使用的
        // 这里可以根据实际情况做选择
        endpoints.reuseRefreshTokens(false);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }


    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(this.keyPair);

        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(new SubjectAttributeUserTokenConverter());
        converter.setAccessTokenConverter(accessTokenConverter);

        return converter;
    }

    @Bean
    public ClientDetailsService clientDetailsService() {
        return new SecurityClientDetailsService(dataSource);
    }

}
