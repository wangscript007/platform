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
    DPT_PARENT_DPT("DPT_PARENT_DPT", "部门-部门"),
    /**
     * 岗位-岗位
     */
    PST_PARENT_PST("PST_PARENT_PST", "岗位-岗位"),
    /**
     * 用户-部门
     */
    USR_CURRENT_DPT("USR_CURRENT_DPT", "用户-部门"),
    /**
     * 用户-岗位
     */
    USR_CURRENT_PST("USR_CURRENT_PST", "用户-岗位");

    /**
     * 类型
     */
    private final String type;
    /**
     * 描述
     */
    private final String desc;

    EntityRelationType(final String type, final String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static EntityRelationType getRelationType(String type) {
        EntityRelationType[] ts = EntityRelationType.values();
        for (EntityRelationType t : ts) {
            if (t.getType().equalsIgnoreCase(type)) {
                return t;
            }
        }
        return null;
    }

    public String getType() {
        return this.type;
    }

    public String getDesc() {
        return this.desc;
    }
}
