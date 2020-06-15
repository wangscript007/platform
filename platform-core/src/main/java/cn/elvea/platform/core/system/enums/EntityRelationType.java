package cn.elvea.platform.core.system.enums;

/**
 * 实体关联类型
 *
 * @author elvea
 */
public enum EntityRelationType {
    /**
     * 部门-部门
     */
    DPT_PARENT_DPT,
    /**
     * 岗位-岗位
     */
    PST_PARENT_PST,
    /**
     * 用户-部门
     */
    USR_CURRENT_DPT,
    /**
     * 用户-岗位
     */
    USR_CURRENT_PST;
}
