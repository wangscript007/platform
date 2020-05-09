package cn.elvea.platform.core.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Position
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PositionDto {
    // 岗位编号
    private String code;
    // 岗位标题
    private String title;
    // 岗位描述
    private String description;
    // 实体状态
    private String status;
    // 实体创建时间
    private String createdAt;
    // 实体创建人
    private String createdBy;
    // 实体修改时间
    private String updatedAt;
    // 实体修改人
    private String updatedBy;
}
