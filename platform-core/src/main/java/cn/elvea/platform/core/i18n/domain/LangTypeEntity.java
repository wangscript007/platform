package cn.elvea.platform.core.i18n.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TagEntity
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_lang_type")
public class LangTypeEntity extends BaseEntity {
    /**
     * 语言
     */
    private String locale;
    /**
     * 多语言文本
     */
    private String label;
    /**
     * 简介
     */
    private String description;
    /**
     * 是否默认语言
     */
    private Boolean defaultInd;
    /**
     * 启用状态
     */
    private Boolean active;
}
