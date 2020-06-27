package cn.elvea.platform.commons.autoconfigure;

import cn.elvea.platform.commons.Context;
import cn.elvea.platform.commons.autoconfigure.properties.CommonsProperties;
import cn.elvea.platform.commons.constants.SystemConstants;
import cn.elvea.platform.commons.persistence.jdbc.callback.IdEntityCallback;
import cn.elvea.platform.commons.persistence.jdbc.dao.CommonDao;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

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
        Assert.notNull(commonsProperties, "CommonsProperties must not be null!");
        Assert.notNull(redisProperties, "RedisProperties must not be null!");

        this.commonsProperties = commonsProperties;
        this.redisProperties = redisProperties;
    }

    /**
     * Context
     *
     * @return {@link Context}
     */
    @Bean
    @ConditionalOnMissingBean
    public Context context(IdWorker idWorker) {
        Assert.notNull(idWorker, "IdWorker must not be null!");
        return new Context(idWorker);
    }

    /**
     * IdEntityCallback
     *
     * @return {@link IdEntityCallback}
     */
    @Bean
    @ConditionalOnMissingBean
    public IdEntityCallback idEntityCallback(Context context) {
        Assert.notNull(context, "Context must not be null!");
        return new IdEntityCallback(context);
    }

    /**
     * CommonDao
     *
     * @return {@link Context}
     */
    @Bean
    @ConditionalOnMissingBean
    public CommonDao commonDao(JdbcTemplate jdbcTemplate) {
        Assert.notNull(jdbcTemplate, "JdbcTemplate must not be null!");
        return new CommonDao(jdbcTemplate);
    }

    /**
     * SpringContextUtils
     *
     * @return {@link SpringContextUtils}
     */
    @Bean
    @ConditionalOnMissingBean
    public SpringContextUtils springContextUtils() {
        return new SpringContextUtils();
    }

    /**
     * RedissonClient
     *
     * @return {@link RedissonClient}
     */
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

    /**
     * RedisLockUtils
     *
     * @return {@link RedisLockUtils}
     */
    @Bean
    @ConditionalOnMissingBean
    public RedisLockUtils redisLockUtils() {
        return new RedisLockUtils(redissonClient());
    }

    /**
     * IdWorker
     *
     * @return {@link IdWorker}
     */
    @Bean
    @ConditionalOnMissingBean
    public IdWorker idWorker() {
        if (SystemConstants.ID_WORKER_TYPE_AUTO.equalsIgnoreCase(this.commonsProperties.getIdWorkerType())) {
            return new IdWorker();
        }
        return new IdWorker(this.commonsProperties.getIdWorkerWorkerId(), this.commonsProperties.getIdWorkerDatacenterId());
    }

}
