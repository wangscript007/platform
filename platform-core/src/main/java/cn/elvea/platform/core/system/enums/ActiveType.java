package cn.elvea.platform.core.system.enums;

import lombok.Getter;

/**
 * 启用类型
 *
 * @author elvea
 */
@Getter
public enum ActiveType {
    /**
     * 启用
     */
    ACTIVE(1, "label_active_type_active"),
    /**
     * 禁用
     */
    INACTIVE(0, "label_active_type_inactive");

    /**
     *
     */
    private final int value;
    /**
     *
     */
    private final String label;

    ActiveType(final int value, final String label) {
        this.value = value;
        this.label = label;
    }

    public static ActiveType getActiveType(int value) {
        ActiveType[] ts = ActiveType.values();
        for (ActiveType t : ts) {
            if (t.getValue() == value) {
                return t;
            }
        }
        return ACTIVE;
    }

}
