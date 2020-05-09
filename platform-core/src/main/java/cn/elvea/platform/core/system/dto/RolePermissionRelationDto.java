package cn.elvea.platform.core.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * RolePermissionRelation
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RolePermissionRelationDto {
    // 角色ID
    private Long roleId;
    // 权限ID
    private Long permissionId;
    // 关联时间
    private Timestamp createdAt;
    // 关联人
    private Long createdBy;
}
