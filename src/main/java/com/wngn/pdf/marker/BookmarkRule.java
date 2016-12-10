package com.wngn.pdf.marker;

/**
 * 书签规则
 * 
 * @author v_wanggang
 * @date 2016年1月20日 上午10:59:06
 */
public class BookmarkRule {

    /** 封页页码 */
    private int home;
    /** 目录页码 */
    private int catalog;
    /** 最大页码 */
    private int maxpage;
    /** 偏移页码 */
    private int offset;

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public int getMaxpage() {
        return maxpage;
    }

    public void setMaxpage(int maxpage) {
        this.maxpage = maxpage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public BookmarkRule() {
    }

    public BookmarkRule(int home, int catalog, int maxpage, int offset) {
        this.home = home;
        this.catalog = catalog;
        this.maxpage = maxpage;
        this.offset = offset;
    }

    public BookmarkRule(int offset) {
        this.offset = offset;
    }

}
