package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DepartmentEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_department")
public class DepartmentEntity extends BaseEntity {
    // 部门编号
    private String code;
    // 部门标题
    private String title;
    // 部门描述
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
