package cn.elvea.platform.config;

import cn.elvea.platform.commons.constants.SystemConstants;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Config
 *
 * @author elvea
 */
@Configuration
@EnableCaching
public class Config {

    /**
     * 多语言文件
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages/messages", "classpath:org/springframework/security/messages");
        messageSource.setDefaultEncoding(SystemConstants.ENCODING);
        return messageSource;
    }

}
