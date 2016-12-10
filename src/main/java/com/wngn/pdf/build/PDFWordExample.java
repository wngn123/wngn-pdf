package com.wngn.pdf.build;

public class PDFWordExample {

    private String en;
    private String ch;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return "PDFWordExample [en=" + en + ", ch=" + ch + "]";
    }

    public PDFWordExample() {
    }

    public PDFWordExample(String en, String ch) {
        super();
        this.en = en;
        this.ch = ch;
    }

}
