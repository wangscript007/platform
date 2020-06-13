package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

/**
 * PermissionEntity
 *
 * @author elvea
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table("sys_permission")
public class PermissionEntity extends BaseEntity {
    /**
     * 权限编号
     */
    private String code;
    /**
     * 权限标题
     */
    private String title;
    /**
     * 权限描述
     */
    private String description;
}
