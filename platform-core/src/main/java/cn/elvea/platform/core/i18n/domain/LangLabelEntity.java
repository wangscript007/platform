package cn.elvea.platform.core.i18n.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TagRelationEntity
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_lang_label")
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
}
