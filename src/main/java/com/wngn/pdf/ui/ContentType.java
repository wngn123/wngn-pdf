package com.wngn.pdf.ui;

public enum ContentType {

    INDEX(0, "index"), SETTING(1, "setting"), FORMAT(2, "format"), TEXT(3, "text"), PAGE(4, "page");

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ContentType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
