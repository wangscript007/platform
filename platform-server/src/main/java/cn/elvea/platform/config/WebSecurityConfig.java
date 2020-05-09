package cn.elvea.platform.config;

import cn.elvea.platform.security.service.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static cn.elvea.platform.commons.constants.SecurityConstants.AUTH_LOGIN_PATH;
import static cn.elvea.platform.commons.constants.SecurityConstants.AUTH_USER_PATH;

/**
 * WebSecurityConfig
 *
 * @author elvea
 */
@Order(1)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityUserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(SecurityUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/.well-known/jwks.json").permitAll()
                .antMatchers("/favicon.ico", "/static/**", "/webjars/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/oauth/*").permitAll()
                .antMatchers(AUTH_LOGIN_PATH).permitAll()
                .antMatchers(AUTH_USER_PATH).permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .ignoringRequestMatchers(request -> "/introspect".equals(request.getRequestURI()))
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }

}
