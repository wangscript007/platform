package cn.elvea.platform.core.tag.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


/**
 * TagEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table("sys_tag")
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
    private String deletedAt;
    /**
     * 删除人
     */
    private String deletedBy;
}
