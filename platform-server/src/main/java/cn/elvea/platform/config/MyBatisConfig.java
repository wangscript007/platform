package cn.elvea.platform.config;

import cn.elvea.platform.commons.persistence.mybatis.interceptor.PaginationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author elvea
 */
@Slf4j
@Configuration
@MapperScan("cn.elvea.platform.core.**.mapper")
public class MyBatisConfig {

    PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @ConditionalOnClass(name = "org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer")
    @ConditionalOnMissingBean
    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return configuration -> {
            configuration.addInterceptor(paginationInterceptor());
        };
    }

}
