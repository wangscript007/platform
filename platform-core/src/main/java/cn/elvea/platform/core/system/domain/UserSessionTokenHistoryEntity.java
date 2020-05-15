package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 用户会话历史记录
 *
 * @author elvea
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_user_session_token_history")
public class UserSessionTokenHistoryEntity extends BaseEntity {
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
     * Access Token
     */
    private String accessToken;
    /**
     * Refresh Token
     */
    private String refreshToken;
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
