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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Web Security
 *
 * @author elvea
 */
@Order(101)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityUserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder,
                             SecurityUserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .mvcMatchers("/.well-known/jwks.json").permitAll()
                .antMatchers("/favicon.ico", "/static/**", "/webjars/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/swagger-ui/**", "/swagger.html", "/api-docs", "/api-docs/swagger-config").permitAll()
                .antMatchers("/api/version").hasAuthority("SCOPE_webapp")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2ResourceServer()
                .jwt();
    }

}
