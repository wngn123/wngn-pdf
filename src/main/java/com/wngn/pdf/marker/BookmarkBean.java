package com.wngn.pdf.marker;

import java.util.HashMap;
import java.util.Map;

/**
 * 书签实体
 * 
 * @author v_wanggang
 * @date 2016年1月20日 上午11:01:32
 */
public class BookmarkBean {

    /** 书签名称 */
    private String title;
    /** 书签跳转页吗 */
    private String page;
    /** 书签等级（父子关系） */
    private int level;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * 解析书签文本
     * <p>
     * 格式：章节 名称 页码 空格分开<br>
     * 第11章 SpringMVC 291 <br>
     * 11.1 SpringMVC快速体验 291 <br>
     * 11.2 Context Loader Listener 295 <br>
     * 11.2.1 Servlet Context Listener的使用 295 <br>
     * </p>
     * 
     * @param contentFormatLine
     * @return
     */
    public static BookmarkBean parseBookmarkText(String contentFormatLine, int offset) {
        BookmarkBean bookmark = new BookmarkBean();
        String title = "";
        Integer destPage = null;
        // 当没有页码在字符串结尾的时候，一般就是书的名字，如果格式正确的话。
        int lastSpaceIndex = contentFormatLine.lastIndexOf(BookmarkConstants.DECOLLATOR_BOOKMARK);
        if (lastSpaceIndex == -1) {
            title = contentFormatLine;
            destPage = 1;
        } else {
            String page = contentFormatLine.substring(lastSpaceIndex + 1);
            if (isPageNumber(page)) {
                destPage = Integer.parseInt(page) + offset;
                title = contentFormatLine.substring(0, lastSpaceIndex);
            } else {
                title = contentFormatLine;
            }
        }
        String[] titleSplit = title.split(BookmarkConstants.DECOLLATOR_BOOKMARK);
        // 章节目录用.区分
        int dotCount = titleSplit[0].split(BookmarkConstants.DECOLLATOR_CHAPTER).length - 1;
        bookmark.setLevel(dotCount);
        bookmark.setPage(destPage + "");
        bookmark.setTitle(title);
        return bookmark;
    }

    public static Map<String, Object> bookmarkToMap(BookmarkBean bookmark) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Title", bookmark.getTitle());
        map.put("Action", "GoTo");
        map.put("Page", bookmark.getPage() + " FitH");
        return map;
    }

    public static Map<String, Object> getBookmarkMap(String title, int page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Title", title);
        map.put("Action", "GoTo");
        map.put("Page", page + " FitH");
        return map;
    }

    public static boolean isPageNumber(String page) {
        try {
            Integer.parseInt(page);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
