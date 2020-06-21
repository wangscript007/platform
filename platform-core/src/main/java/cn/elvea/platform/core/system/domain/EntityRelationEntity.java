package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


/**
 * EntityRelationEntity
 *
 * @author elvea
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table("sys_entity_relation")
public class EntityRelationEntity extends BaseEntity {
    /**
     * 关联类型
     */
    private String relationType;
    /**
     * 祖先ID
     */
    private Long ancestorId;
    /**
     * 实体ID
     */
    private Long entityId;
    /**
     * 是否直接上级
     */
    private Boolean parentInd;
    /**
     * 层级序号
     */
    private Integer relationIndex;
    /**
     * 层级路径
     */
    private String fullPath;
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
}
