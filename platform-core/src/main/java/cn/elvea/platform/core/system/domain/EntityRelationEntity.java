package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.*;
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
@Table("sys_actor_relation")
public class EntityRelationEntity extends BaseEntity {
    // 实体关联父ID
    private Long parentId;
    // 实体关联子ID
    private Long childId;
    // 实体关联是否直接关联
    private Boolean parentInd;
    // 实体关联层级
    private Integer level;
    // 实体关联类型
    private String type;
    // 实体关联时间
    private LocalDateTime createdAt;
    // 实体关联人
    private Long createdBy;
}
