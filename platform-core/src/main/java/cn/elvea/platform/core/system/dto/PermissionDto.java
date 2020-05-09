package cn.elvea.platform.core.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Permission
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionDto {
    // 权限编号
    private String code;
    // 权限标题
    private String title;
    // 权限描述
    private String description;
}
