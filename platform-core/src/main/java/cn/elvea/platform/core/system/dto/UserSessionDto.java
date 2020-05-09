package cn.elvea.platform.core.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * UserSession
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserSessionDto {
    // 会话ID
    private String sessionId;
    // 实体ID
    private String entityId;
    // 用户名
    private String username;
    // 登录主机
    private String host;
    // 登录设备
    private String device;
    // 最后访问时间
    private Date lastAccessDatetime;
    // 开始时间
    private Date startDatetime;
    // 结束时间
    private Date endDatetime;
}
