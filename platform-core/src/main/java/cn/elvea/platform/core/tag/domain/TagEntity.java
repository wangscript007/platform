package cn.elvea.platform.core.tag.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TagEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_tag")
public class TagEntity extends BaseEntity {
    /**
     * 标签类型ID
     */
    private Long tagTypeId;
    /**
     * 标题
     */
    private Long title;
    /**
     * 简介
     */
    private Long description;
    /**
     * 启用状态
     */
    private Boolean active;
    /**
     * 创建时间
     */
    private String createdAt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 修改时间
     */
    private String updatedAt;
    /**
     * 修改人
     */
    private String updatedBy;
    /**
     * 删除时间
     */
    private String deletedAt;
    /**
     * 删除人
     */
    private String deletedBy;
}
