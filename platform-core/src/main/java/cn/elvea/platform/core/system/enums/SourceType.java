package cn.elvea.platform.core.system.enums;

/**
 * 实体来源类型
 *
 * @author elvea
 */
public enum SourceType {
    SYS(1, "SYS", "系统自带"),
    NORMAL(2, "NORMAL", "正常添加"),
    IMP(3, "IMP", "页面导入"),
    SYNC(4, "SYNC", "外部同步");

    // 类型
    private final int type;
    // 类型
    private final String code;
    // 描述
    private final String desc;

    SourceType(final int type, final String code, final String desc) {
        this.code = code;
        this.type = type;
        this.desc = desc;
    }

    public static SourceType getSourceType(int type) {
        SourceType[] ts = SourceType.values();
        for (SourceType t : ts) {
            if (t.getType() == type) {
                return t;
            }
        }
        return NORMAL;
    }

    public int getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
