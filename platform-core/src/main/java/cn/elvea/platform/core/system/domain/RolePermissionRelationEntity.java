package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * RolePermissionRelationEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_role_permission_relation")
public class RolePermissionRelationEntity extends BaseEntity {
    // 角色ID
    private Long roleId;
    // 权限ID
    private Long permissionId;
    // 关联时间
    private Timestamp createdAt;
    // 关联人
    private Long createdBy;
}
