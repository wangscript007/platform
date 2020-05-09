package cn.elvea.platform.core.system.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

/**
 * RoleTypeDto
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "RoleTypeDto", description = "角色类型")
public class RoleTypeDto implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 编号
     */
    private String code;
    /**
     * 文本
     */
    private String label;
    /**
     * 备注
     */
    private String description;
}
