package com.zzia.wngn.pdf.marker;

public enum ReserverType {

    RESERVED_OLD_OUTLINE(1), RESERVED_NON_OUTLINE(2);

    /** 错误内容 */
    public int value;

    private ReserverType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name();
    }
}
