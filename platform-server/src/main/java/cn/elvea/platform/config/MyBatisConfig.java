package cn.elvea.platform.config;

import cn.elvea.platform.commons.persistence.mybatis.interceptor.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author elvea
 */
@Configuration
@MapperScan("cn.elvea.platform.core.system.mapper")
public class MyBatisConfig {

    @Bean
    PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return configuration -> configuration.addInterceptor(paginationInterceptor());
    }

}
