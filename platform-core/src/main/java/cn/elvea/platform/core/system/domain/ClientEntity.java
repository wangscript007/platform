package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * ClientEntity
 *
 * @author elvea
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table("sys_client")
public class ClientEntity extends BaseEntity {
    /**
     * Client ID
     */
    private String clientId;
    /**
     * Client Secret
     */
    private String clientSecret;
    /**
     * Authorization Grant Type
     */
    private String authorizationGrantTypes;
    /**
     * Client Authentication Method
     */
    private String clientAuthenticationMethods;
    /**
     * Redirect Uri
     */
    private String redirectUris;
    /**
     * Score
     */
    private String scopes;
    /**
     * 用户状态
     */
    private String description;
    /**
     * 启用状态
     */
    private Boolean active;
    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createdAt;
    /**
     * 创建人
     */
    @CreatedBy
    private Long createdBy;
    /**
     * 最后修改时间
     */
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
    /**
     * 最后修改人
     */
    @LastModifiedBy
    private Long lastModifiedBy;
    /**
     * 删除时间
     */
    private LocalDateTime deletedAt;
    /**
     * 删除人
     */
    private String deletedBy;
}
