package cn.elvea.platform.core.system.enums;

/**
 * 角色类型
 *
 * @author elvea
 */
public enum RoleType {
    SYSTEM_ADMINISTRATOR(1, new int[]{PermissionType.SYSTEM.getType(), PermissionType.ADMIN.getType()}, "超级管理员"),
    ADMINISTRATOR(2, new int[]{PermissionType.ADMIN.getType()}, "管理员"),
    USER(3, new int[]{PermissionType.USER.getType()}, "普通用户");

    // 类型
    private final int type;
    // 描述
    private final String desc;
    // 当前角色包含的权限类型
    private final int[] includePermissionTypes;

    RoleType(final int type, final int[] includePermissionTypes, final String desc) {
        this.type = type;
        this.desc = desc;
        this.includePermissionTypes = includePermissionTypes;
    }

    public static RoleType getRoleType(int type) {
        RoleType[] ts = RoleType.values();
        for (RoleType t : ts) {
            if (t.getType() == type) {
                return t;
            }
        }
        return USER;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public int[] getIncludePermissionTypes() {
        return includePermissionTypes;
    }
}
