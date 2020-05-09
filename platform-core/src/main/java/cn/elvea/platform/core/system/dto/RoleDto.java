package cn.elvea.platform.core.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * RoleDto
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleDto implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 角色编号
     */
    private String code;
    /**
     * 角色标题
     */
    private String title;
    /**
     * 角色描述
     */
    private String description;
}
