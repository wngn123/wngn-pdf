package com.zzia.wngn.pdf.build;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFBuilder {

    protected static Font titleFont;
    protected static Font sectFont;
    protected static Font wordFont;
    protected static Font pronFont;
    protected static Font tranFont;
    protected static Font examEnFont;
    protected static Font examChFont;
    private Document document = null;
    private Chapter chapter = null;
    private int chapterIndex = 1;

    static {
        try {
            BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
            titleFont = new Font(bfChinese, 12, Font.BOLD, BaseColor.BLACK);
            sectFont = new Font(FontFamily.UNDEFINED, 8, Font.NORMAL, BaseColor.BLACK);
            wordFont = new Font(FontFamily.UNDEFINED, 12, Font.NORMAL, BaseColor.RED);
            pronFont = new Font(bfChinese, 8, Font.NORMAL, BaseColor.BLUE);
            tranFont = new Font(bfChinese, 8, Font.NORMAL, BaseColor.BLUE);
            examEnFont = new Font(FontFamily.UNDEFINED, 8, Font.NORMAL, BaseColor.GREEN);
            examChFont = new Font(bfChinese, 8, Font.NORMAL, BaseColor.GREEN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PDFBuilder createDocument() throws Exception {
        this.document = new Document();
        String fileName = "D:\\temp\\word\\pdf.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.addTitle("source word");// 添加标题
        document.addAuthor("wanggang");// 添加作者
        document.addSubject("source word");// 添加主题
        document.addCreator("wangang");// 添加创作人
        document.addKeywords("English java source");// 添加关键字
        document.addCreationDate();// 添加制作时间
        document.open();
        return this;
    }

    public PDFBuilder createDocument(String path, String title, String author, String subject, String creator)
            throws Exception {
        this.document = new Document();
        String fileName = path;
        PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.addTitle(title);// 添加标题
        document.addAuthor(author);// 添加作者
        document.addSubject(subject);// 添加主题
        document.addCreator(creator);// 添加创作人
        document.addKeywords("English java source");// 添加关键字
        document.addCreationDate();// 添加制作时间
        document.open();
        return this;
    }

    public PDFBuilder createChapter(String title) throws Exception {
        if (this.chapter != null) {
            this.document.add(this.chapter);
        }
        if (title != null) {
            this.chapter = new Chapter(title, this.chapterIndex++);
        }
        return this;
    }

    public PDFBuilder createSection(PDFWord word) throws Exception {
        this.chapter.addSection(new Paragraph(word.getWord(), PDFBuilder.sectFont));
        List<Paragraph> list = this.getWordParagraph(word);
        for (Paragraph paragraph : list) {
            this.document.add(paragraph);
        }
        return this;
    }

    public void close() {
        this.document.close();
    }

    private List<Paragraph> getWordParagraph(PDFWord word) {
        List<Paragraph> list = new ArrayList<Paragraph>();
        Paragraph paragraph = null;
        // 单词：
        paragraph = new Paragraph(word.getWord(), PDFBuilder.wordFont);
        list.add(paragraph);
        // 音标：
        paragraph = new Paragraph("音标", PDFBuilder.titleFont);
        list.add(paragraph);
        paragraph = new Paragraph(word.getPron(), PDFBuilder.pronFont);
        list.add(paragraph);
        // 释义：
        paragraph = new Paragraph("释义", PDFBuilder.titleFont);
        list.add(paragraph);
        if (word.getTarns() != null && word.getTarns().size() > 0) {
            for (PDFWordTranslation tran : word.getTarns()) {
                String tran_ = tran.getPos() + "  " + tran.getTran();
                paragraph = new Paragraph(tran_, PDFBuilder.tranFont);
                list.add(paragraph);
            }
        }
        paragraph = new Paragraph("例句 ", PDFBuilder.titleFont);
        list.add(paragraph);
        // 例句：
        if (word.getExams() != null && word.getExams().size() > 0) {
            for (PDFWordExample exam : word.getExams()) {
                paragraph = new Paragraph(exam.getEn(), PDFBuilder.examEnFont);
                list.add(paragraph);
                paragraph = new Paragraph(exam.getCh(), PDFBuilder.examChFont);
                list.add(paragraph);
            }
        }
        return list;
    }

}
