package cn.elvea.platform.core.system.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * RolePermissionRelation
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RolePermissionRelationDto implements Serializable {
    // 角色ID
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;
    // 权限ID
    @JsonSerialize(using = ToStringSerializer.class)
    private Long permissionId;
    // 关联时间
    private Timestamp createdAt;
    // 关联人
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createdBy;
}
