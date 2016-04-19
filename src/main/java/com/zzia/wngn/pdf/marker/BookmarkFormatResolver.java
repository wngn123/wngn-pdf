package com.zzia.wngn.pdf.marker;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.SimpleBookmark;

/**
 * @title PDF书签格式化
 * @author wanggang
 * @date 2016年4月19日 上午10:20:38
 * @email wngn123@163.com
 * @descripe 对有书签的PDF书籍，将其书签各式花成标准格式
 */
public class BookmarkFormatResolver extends BookmarkResolver {

    /**
     * 格式化书签对象
     * 
     * <p>主要将书签的打开形式由Hit改为HitH
     * @param outlines 书签列表
     */
    private void formatterBookmark(List<HashMap<String, Object>> outlines) {
        for (HashMap<String, Object> hashMap : outlines) {
            if (hashMap.containsKey("Kids")) {
                @SuppressWarnings("unchecked")
                List<HashMap<String, Object>> kids = (List<HashMap<String, Object>>) (hashMap.get("Kids"));
                formatterBookmark(kids);
            }
            if (hashMap.containsKey("Page")) {
                String page = (String) hashMap.get("Page");
                String[] pages = page.split(" ");
                page = pages[0] + " FitH";
                hashMap.put("Page", page);
            }
        }
    }

    @Override
    protected void builderBookmark() {
        try {
            PdfReader reader = new PdfReader(super.getSourcePath());
            /**
             * 防止出现PdfReader not opened with owner password异常
             */
            PdfReader.unethicalreading = true;
            List<HashMap<String, Object>> outlines = new ArrayList<HashMap<String, Object>>();
            outlines.addAll(SimpleBookmark.getBookmark(reader));
            formatterBookmark(outlines);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(super.getDestPath()));
            stamper.setOutlines(outlines);
            stamper.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("生成书签错误", e);
        }

    }

    @Override
    protected void verify() {
        if (super.destPath == null || super.destPath.length() == 0) {
            if (super.targetName == null) {
                super.targetName = getFileName();
            }

            if (super.targetPath == null) {
                super.targetPath = getFilePath();
            }
            super.destPath = super.targetPath + "/" + super.targetName;
        }
        if (super.sourcePath == null || super.sourcePath.length() == 0) {
            throw new IllegalArgumentException("PDF源文件路径不能为null");
        }
    }

}
