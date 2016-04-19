package com.zzia.wngn.pdf.marker;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.SimpleBookmark;

public class PDFMarkAmend {

    public static void main(String[] args) throws Exception {
        String sourcePath = "D:\\temp\\a.pdf";
        String targetPath = "D:\\temp\\1\\a.pdf";

        PdfReader reader = new PdfReader(sourcePath);
        List<HashMap<String, Object>> outlines = new ArrayList<HashMap<String, Object>>();
        outlines.addAll(SimpleBookmark.getBookmark(reader));
        // Page=18 Fit
        // {Action=GoTo, Page=18 Fit, Title= 第1章 预备知识}
        for (HashMap<String, Object> hashMap : outlines) {
            amend(hashMap);
        }

        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(targetPath));
        stamper.setOutlines(outlines);
        stamper.close();
    }

    @SuppressWarnings("unchecked")
    public static void amend(HashMap<String, Object> hashMap) {
        hashMap.put("Page", hashMap.get("Page").toString().replace("Fit", "FitH"));
        System.out.println(hashMap.get("Page") + "   " + hashMap.get("Title"));
        if (hashMap.get("Kids") != null) {
            List<HashMap<String, Object>> outlines = (List<HashMap<String, Object>>) hashMap.get("Kids");
            for (HashMap<String, Object> map : outlines) {
                amend(map);
            }
        }
    }
}
