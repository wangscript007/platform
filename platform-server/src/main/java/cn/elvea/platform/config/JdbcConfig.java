package cn.elvea.platform.config;

import cn.elvea.platform.commons.Context;
import cn.elvea.platform.commons.persistence.jdbc.auditor.UserAuditorAware;
import cn.elvea.platform.commons.persistence.jdbc.converter.BooleanToIntegerConverter;
import cn.elvea.platform.commons.persistence.jdbc.converter.IntegerToBooleanConverter;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * JdbcConfig
 *
 * @author elvea
 */
@Slf4j
@Configuration
@EnableJdbcAuditing
@EnableJdbcRepositories("cn.elvea.platform.core.**.repository")
@MapperScan("cn.elvea.platform.core.**.mapper")
public class JdbcConfig extends AbstractJdbcConfiguration {

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Arrays.asList(
                new IntegerToBooleanConverter(),
                new BooleanToIntegerConverter())
        );
    }

    @Bean
    public AuditorAware<Long> auditorAware(Context context) {
        return new UserAuditorAware(context);
    }

}
