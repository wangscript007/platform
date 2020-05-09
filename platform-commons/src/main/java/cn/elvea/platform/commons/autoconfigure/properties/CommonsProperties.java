package cn.elvea.platform.commons.autoconfigure.properties;

import cn.elvea.platform.commons.constants.SystemConstants;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * CommonsProperties
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "platform")
public class CommonsProperties {

    /**
     * 调试模式
     */
    private boolean debug = false;

    /**
     * 主键生成器的初始策略
     * 默认为手工设置
     */
    private String idWorkerType = SystemConstants.ID_WORKER_TYPE_MANUAL;

    /**
     * 主键生成器的数据中心ID
     */
    private Long idWorkerDatacenterId = 1L;

    /**
     * 主键生成器的工作机器ID
     */
    private Long idWorkerWorkerId = 1L;

}
