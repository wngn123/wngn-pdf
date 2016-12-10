package com.wngn.pdf.marker;

/**
 * 常量
 * 
 * @author v_wanggang
 * @date 2016年1月20日 下午1:18:33
 */
public class BookmarkConstants {

    /** 保留旧得书签 */
    public final static int RESERVED_OLD_OUTLINE = 1;
    /** 全部添加新的书签 */
    public final static int RESERVED_NON_OUTLINE = 2;

    /** 书签分隔符用空格 */
    public final static String DECOLLATOR_BOOKMARK = " ";
    /** 章节分隔符用点号 */
    public final static String DECOLLATOR_CHAPTER = "\\.";

    /** 首页 */
    public final static String HOME = "home";
    /** 目录 */
    public final static String CATALOG = "catalog";
    /** 最大页码 */
    public final static String MAXPAGE = "maxpage";
    /** 偏移量 */
    public final static String OFFSET = "offset";

}
