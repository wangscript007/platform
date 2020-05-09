package cn.elvea.platform.core.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * UserRole
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRoleRelationDto {
    // 实体ID
    private Long entityId;
    // 权限ID
    private Long permissionId;
    // 关联时间
    private Timestamp createdAt;
    // 关联人
    private Long createdBy;
}
