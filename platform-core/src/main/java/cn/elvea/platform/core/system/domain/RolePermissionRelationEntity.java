package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

/**
 * RolePermissionRelationEntity
 *
 * @author elvea
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table("sys_role_permission_relation")
public class RolePermissionRelationEntity extends BaseEntity {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long permissionId;
    /**
     * 创建时间
     */
    private Timestamp createdAt;
    /**
     * 创建人
     */
    private Long createdBy;
}
