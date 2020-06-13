package cn.elvea.platform.core.i18n.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * TagRelationEntity
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table("sys_lang_label")
public class LangLabelEntity extends BaseEntity {
    /**
     * 语言类型ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long langTypeId;
    /**
     * 多语言文本
     */
    private String label;
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
}
