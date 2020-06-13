package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

/**
 * RoleTypeEntity
 *
 * @author elvea
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table("sys_role_type")
public class RoleTypeEntity extends BaseEntity {
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
}
