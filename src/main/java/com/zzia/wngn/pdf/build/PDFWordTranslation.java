package com.zzia.wngn.pdf.build;

public class PDFWordTranslation {

    private String pos;
    private String tran;

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTran() {
        return tran;
    }

    public void setTran(String tran) {
        this.tran = tran;
    }

    @Override
    public String toString() {
        return "PDFWordTranslation [pos=" + pos + ", tran=" + tran + "]";
    }

    public PDFWordTranslation() {
    }

    public PDFWordTranslation(String pos, String tran) {
        super();
        this.pos = pos;
        this.tran = tran;
    }

}
