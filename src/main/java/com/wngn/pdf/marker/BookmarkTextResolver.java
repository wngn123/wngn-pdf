package com.wngn.pdf.marker;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.SimpleBookmark;

/**
 * 通过目录文件生成书签
 * 
 * @author v_wanggang
 * @date 2016年1月20日 下午1:20:36
 */
public class BookmarkTextResolver extends BookmarkResolver {

    @SuppressWarnings("unchecked")
    @Override
    public void builderBookmark() {
        try {
            PdfReader reader = new PdfReader(super.getSourcePath());
            /**
             * 防止出现PdfReader not opened with owner password异常
             */
            PdfReader.unethicalreading = true;
            List<HashMap<String, Object>> outlines = new ArrayList<HashMap<String, Object>>();
            if (super.pattern.getValue() == ReserverType.RESERVED_OLD_OUTLINE.getValue()) {
                outlines.addAll(SimpleBookmark.getBookmark(reader));
            }
            BufferedReader bufRead = new BufferedReader(
                    new InputStreamReader(new FileInputStream(super.getTextPath()), "UTF-8"));
            List<Map<String, Object>> outlines_ = new ArrayList<Map<String, Object>>();
            addBookmarks(bufRead, outlines_, super.rule.getOffset());
            outlines.addAll((Collection<? extends HashMap<String, Object>>) outlines_);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(super.getDestPath()));
            stamper.setOutlines(outlines);
            stamper.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("生成书签错误", e);
        }

    }

    /**
     * 添加书签
     * 
     * @param bufRead
     * @param outlines
     * @param offset
     * @throws Exception
     */
    private void addBookmarks(BufferedReader bufRead, List<Map<String, Object>> outlines, int offset) throws Exception {
        String contentFormatLine = null;
        Map<String, Object> preOutline = null;
        Map<String, Object> parentOutline = null;
        // 读取第一行
        while ((contentFormatLine = bufRead.readLine()) != null) {
            BookmarkBean bookmark = BookmarkBean.parseBookmarkText(contentFormatLine.trim(), offset);
            Map<String, Object> map = BookmarkBean.bookmarkToMap(bookmark);
            // 顶层书签
            if (bookmark.getLevel() == 0) {
                outlines.add(map);
                parentOutline = map;// 父级书签
            } else if (bookmark.getLevel() == 1) {
                if (parentOutline.containsKey("Kids")) {
                    @SuppressWarnings("unchecked")
                    List<Map<String, Object>> kids = (List<Map<String, Object>>) (parentOutline.get("Kids"));
                    kids.add(map);
                } else {
                    List<Map<String, Object>> kids = new ArrayList<Map<String, Object>>();
                    kids.add(map);
                    parentOutline.put("Kids", kids);// 父书签添加
                }
                preOutline = map;// 上级书签
            } else if (bookmark.getLevel() == 2) {
                if (preOutline.containsKey("Kids")) {
                    @SuppressWarnings("unchecked")
                    List<Map<String, Object>> kids = (List<Map<String, Object>>) (preOutline.get("Kids"));
                    kids.add(map);
                } else {
                    List<Map<String, Object>> kids = new ArrayList<Map<String, Object>>();
                    kids.add(map);
                    preOutline.put("Kids", kids);// 父书签添加
                }
            }
        }
    }

    @Override
    public void verify() {
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

        if (super.textPath == null || super.textPath.length() == 0) {
            throw new IllegalArgumentException("PDF目录文件路径不能为null");
        }

    }

}