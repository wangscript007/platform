package cn.elvea.platform.core.tag.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TagRelationEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_tag_relation")
public class TagRelationEntity extends BaseEntity {
    /**
     * 标签类型ID
     */
    private Long tagTypeId;
    /**
     * 标签明细ID
     */
    private Long tagId;
    /**
     * 目标类型
     */
    private Long targetType;
    /**
     * 目标实体ID
     */
    private Long targetEntityId;
    /**
     * 创建时间
     */
    private String createdAt;
    /**
     * 创建人
     */
    private String createdBy;
}
