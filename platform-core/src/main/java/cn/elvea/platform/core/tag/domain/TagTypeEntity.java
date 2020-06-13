package cn.elvea.platform.core.tag.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.relational.core.mapping.Table;

/**
 * TagEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table("sys_tag_type")
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
