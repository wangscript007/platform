package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * EntityRelationEntity
 *
 * @author elvea
 */
@Entity
@Table(name = "sys_actor_relation")
public class EntityRelationEntity extends BaseEntity {
    public static final String R_TYPE_PARENT = "_PARENT_";
    public static final String R_TYPE_CURRENT = "_CURRENT_";
    public final static String R_ORG_PARENT_ORG = "ORG_PARENT_ORG";
    public final static String R_DPT_PARENT_DPT = "DPT_PARENT_DPT";
    public final static String R_PST_PARENT_PST = "PST_PARENT_PST";
    public final static String R_USR_CURRENT_ORG = "USR_CURRENT_ORG";
    public final static String R_USR_CURRENT_DPT = "USR_CURRENT_DPT";
    public final static String R_USR_CURRENT_PST = "USR_CURRENT_PST";

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
    private Timestamp createdAt;
    // 实体关联人
    private Long createdBy;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public Boolean getParentInd() {
        return parentInd;
    }

    public void setParentInd(Boolean parentInd) {
        this.parentInd = parentInd;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
}
