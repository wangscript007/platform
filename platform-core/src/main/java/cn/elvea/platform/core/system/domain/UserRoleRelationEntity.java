package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * UserRoleRelationEntity
 *
 * @author elvea
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table("sys_user_role_relation")
public class UserRoleRelationEntity extends BaseEntity {
    /**
     * 实体ID
     */
    private Long entityId;
    /**
     * 权限ID
     */
    private Long permissionId;
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
}
