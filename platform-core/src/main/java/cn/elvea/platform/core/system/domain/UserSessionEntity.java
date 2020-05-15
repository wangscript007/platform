package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 用户会话记录
 *
 * @author elvea
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_user_session")
public class UserSessionEntity extends BaseEntity {
    /**
     * 用户ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    /**
     * 会话ID
     */
    private String sessionId;
    /**
     * 登录主机
     */
    private String host;
    /**
     * 登录设备
     */
    private String device;
    /**
     * 客户端版本
     */
    private String clientVersion;
    /**
     * 登录平台
     */
    private String platform;
    /**
     * Access Token
     */
    private String accessToken;
    /**
     * Refresh Token
     */
    private String refreshToken;
    /**
     * 会话开始时间
     */
    private LocalDateTime startDatetime;
    /**
     * 最后访问时间
     */
    private LocalDateTime lastAccessDatetime;
    /**
     * 会话结束时间
     */
    private LocalDateTime endDatetime;
    /**
     * 会话时长
     */
    private Long totalTime;
    /**
     * 年
     */
    private Integer startYear;
    /**
     * 月
     */
    private Integer startMonth;
    /**
     * 日
     */
    private Integer startDay;
    /**
     * 时
     */
    private Integer startHour;
    /**
     * 分
     */
    private Integer startMinute;
    /**
     * 创建人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private String createdBy;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
}
