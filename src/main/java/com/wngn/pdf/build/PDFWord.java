package com.wngn.pdf.build;

import java.util.List;

public class PDFWord {

    private String word;
    private String pron;
    private List<PDFWordTranslation> tarns;
    private List<PDFWordExample> exams;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPron() {
        return pron;
    }

    public void setPron(String pron) {
        this.pron = pron;
    }

    public List<PDFWordTranslation> getTarns() {
        return tarns;
    }

    public void setTarns(List<PDFWordTranslation> tarns) {
        this.tarns = tarns;
    }

    public List<PDFWordExample> getExams() {
        return exams;
    }

    public void setExams(List<PDFWordExample> exams) {
        this.exams = exams;
    }

    public PDFWord() {
        super();
    }

}
