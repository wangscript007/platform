package cn.elvea.platform.commons.autoconfigure;

import cn.elvea.platform.commons.Context;
import cn.elvea.platform.commons.autoconfigure.properties.CommonsProperties;
import cn.elvea.platform.commons.constants.SystemConstants;
import cn.elvea.platform.commons.persistence.jdbc.callback.IdEntityCallback;
import cn.elvea.platform.commons.sequence.IdWorker;
import cn.elvea.platform.commons.utils.RedisLockUtils;
import cn.elvea.platform.commons.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CommonsAutoConfiguration
 *
 * @author elvea
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({CommonsProperties.class})
public class CommonsAutoConfiguration {

    private final CommonsProperties commonsProperties;

    private final RedisProperties redisProperties;

    public CommonsAutoConfiguration(CommonsProperties commonsProperties, RedisProperties redisProperties) {
        this.commonsProperties = commonsProperties;
        this.redisProperties = redisProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public Context context(IdWorker idWorker) {
        return new Context(idWorker);
    }

    @Bean
    @ConditionalOnMissingBean
    public IdEntityCallback idEntityCallback() {
        return new IdEntityCallback();
    }

    @Bean
    @ConditionalOnMissingBean
    public SpringContextUtils springContextUtils() {
        return new SpringContextUtils();
    }

    @Bean
    @ConditionalOnMissingBean
    public RedissonClient redissonClient() {
        org.redisson.config.Config config = new org.redisson.config.Config();
        if (StringUtils.isNotEmpty(redisProperties.getPassword())) {
            config.useSingleServer()
                    .setAddress("redis://" + redisProperties.getHost() + ":" + redisProperties.getPort())
                    .setPassword(redisProperties.getPassword())
                    .setDatabase(redisProperties.getDatabase());
        } else {
            config.useSingleServer()
                    .setAddress("redis://" + redisProperties.getHost() + ":" + redisProperties.getPort())
                    .setDatabase(redisProperties.getDatabase());
        }
        try {
            log.debug("Create RedissonClient [{}] [{}] [{}]...",
                    redisProperties.getHost(), redisProperties.getPort(), redisProperties.getDatabase());
            return Redisson.create(config);
        } catch (Exception e) {
            log.error("Create RedissonClient [{}] [{}] [{}] failed. Exception : ",
                    redisProperties.getHost(), redisProperties.getPort(), redisProperties.getDatabase(), e);
            return null;
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public RedisLockUtils redisLockUtils() {
        return new RedisLockUtils(redissonClient());
    }

    @Bean
    @ConditionalOnMissingBean
    public IdWorker idWorker() {
        if (SystemConstants.ID_WORKER_TYPE_AUTO.equalsIgnoreCase(this.commonsProperties.getIdWorkerType())) {
            // 基于Redis自动生成，当前未实现
            return new IdWorker();
        }
        // 手工设置
        return new IdWorker(this.commonsProperties.getIdWorkerWorkerId(), this.commonsProperties.getIdWorkerDatacenterId());
    }

}
