package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PermissionEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_permission")
public class PermissionEntity extends BaseEntity {
    // 权限编号
    private String code;
    // 权限标题
    private String title;
    // 权限描述
    private String description;
}
