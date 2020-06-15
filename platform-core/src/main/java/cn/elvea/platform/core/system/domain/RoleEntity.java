package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * RoleEntity
 *
 * @author elvea
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table("sys_role")
public class RoleEntity extends BaseEntity {
    /**
     * 角色类型ID
     */
    private Long roleTypeId;
    /**
     * 编号
     */
    private String code;
    /**
     * 文本
     */
    private String label;
    /**
     * 描述
     */
    private String description;
    /**
     * 启用状态
     */
    private Boolean active;
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
    /**
     * 最后修改时间
     */
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
    /**
     * 最后修改人
     */
    @LastModifiedBy
    private Long lastModifiedBy;
    /**
     * 删除时间
     */
    private LocalDateTime deletedAt;
    /**
     * 删除人
     */
    private String deletedBy;
}
