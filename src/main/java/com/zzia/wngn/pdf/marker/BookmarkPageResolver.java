package com.zzia.wngn.pdf.marker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.SimpleBookmark;

/**
 * 通过页码生成书签
 * 
 * @author v_wanggang
 * @date 2016年1月20日 下午1:21:12
 */
public class BookmarkPageResolver extends BookmarkResolver {

    @SuppressWarnings("unchecked")
    @Override
    public void builderBookmark() {
        try {
            PdfReader reader = new PdfReader(super.sourcePath);
            PdfReader.unethicalreading = true;
            List<HashMap<String, Object>> outlines = new ArrayList<HashMap<String, Object>>();
            if (super.pattern.getValue() == ReserverType.RESERVED_OLD_OUTLINE.getValue()) {
                outlines.addAll(SimpleBookmark.getBookmark(reader));
            }
            List<Map<String, Object>> outlines_ = addBookmarks(super.rule);
            outlines.addAll((Collection<? extends HashMap<String, Object>>) outlines_);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(super.getDestPath()));
            stamper.setOutlines(outlines);
            stamper.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("生成书签错误", e);
        }

    }

    private List<Map<String, Object>> addBookmarks(BookmarkRule rule) {
        List<Map<String, Object>> outlines = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = BookmarkBean.getBookmarkMap("首页", rule.getHome() > 0 ? rule.getHome() : 1);
        outlines.add(map);
        if (rule.getCatalog() > 0) {
            map = BookmarkBean.getBookmarkMap("目录", rule.getCatalog());
            outlines.add(map);
        }
        if (rule.getMaxpage() > 0) {
            for (int i = 1; i <= rule.getMaxpage(); i++) {
                map = BookmarkBean.getBookmarkMap(i + "--" + (i + rule.getOffset()), i + rule.getOffset());
                outlines.add(map);
            }
        }
        return outlines;
    }

    @SuppressWarnings("unchecked")
    public void builderBookmark(String destPdf, String sourcePdf, Map<String, Integer> paramMap, int pattern)
            throws IOException, DocumentException {
        if (pattern != BookmarkConstants.RESERVED_OLD_OUTLINE && pattern != BookmarkConstants.RESERVED_NON_OUTLINE) {
            throw new RuntimeException("生成书签模式为：1(保留旧书签模式),2(全部生产新书签模式)");
        }
        PdfReader reader = new PdfReader(sourcePdf);
        List<HashMap<String, Object>> outlines = new ArrayList<HashMap<String, Object>>();
        if (pattern == BookmarkConstants.RESERVED_OLD_OUTLINE) {
            outlines.addAll(SimpleBookmark.getBookmark(reader));
        }
        List<Map<String, Object>> outlines_ = addBookmarks(paramMap);
        outlines.addAll((Collection<? extends HashMap<String, Object>>) outlines_);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destPdf));
        stamper.setOutlines(outlines);
        stamper.close();
    }

    private List<Map<String, Object>> addBookmarks(Map<String, Integer> paramMap) {
        List<Map<String, Object>> outlines = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = BookmarkBean.getBookmarkMap("首页",
                paramMap.get(BookmarkConstants.HOME) != null ? paramMap.get(BookmarkConstants.HOME) : 1);
        outlines.add(map);
        if (paramMap.get(BookmarkConstants.CATALOG) != null) {
            map = BookmarkBean.getBookmarkMap("目录", paramMap.get(BookmarkConstants.CATALOG));
            outlines.add(map);
        }
        if (paramMap.get(BookmarkConstants.MAXPAGE) != null && paramMap.get(BookmarkConstants.OFFSET) != null) {
            for (int i = 1; i <= paramMap.get(BookmarkConstants.MAXPAGE); i++) {
                map = BookmarkBean.getBookmarkMap(i + "--" + (i + paramMap.get(BookmarkConstants.OFFSET)),
                        i + paramMap.get(BookmarkConstants.OFFSET));
                outlines.add(map);
            }
        }
        return outlines;
    }

    public static void main(String[] args) throws IOException, DocumentException {
        BookmarkPageResolver book = new BookmarkPageResolver();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(BookmarkConstants.HOME, 1);
        map.put(BookmarkConstants.CATALOG, 9);
        map.put(BookmarkConstants.MAXPAGE, 386);
        map.put(BookmarkConstants.OFFSET, 11);

        book.builderBookmark("D:\\temp\\demo-bookmark1.pdf", "D:\\temp\\demo-bookmark_1.pdf", map,
                BookmarkConstants.RESERVED_NON_OUTLINE);
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

        if (super.rule.getMaxpage() <= 0) {
            throw new IllegalArgumentException("PDF页码必须大于0");
        }
    }

}