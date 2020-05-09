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
@Table(name = "sys_tag_type")
public class TagTypeEntity extends BaseEntity {
    /**
     * 编号
     */
    private String code;
    /**
     * 文本
     */
    private String label;
    /**
     * 简介
     */
    private String description;
}
