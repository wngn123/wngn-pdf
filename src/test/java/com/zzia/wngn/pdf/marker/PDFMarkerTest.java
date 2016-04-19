package com.zzia.wngn.pdf.marker;

import org.junit.Test;

public class PDFMarkerTest {

    @Test
    public void test() {
        String sourcePath = "D:\\temp\\a.pdf";
        String textPath = "D:\\temp\\mark.txt";
        BookmarkResolver resolver = new BookmarkTextResolver();
        BookmarkRule rule = new BookmarkRule();
        rule.setHome(1);
        rule.setCatalog(9);
        rule.setMaxpage(605);
        rule.setOffset(24);
        resolver.setTextPath(textPath);
        resolver.setSourcePath(sourcePath);
        resolver.builderBookmark(rule, ReserverType.RESERVED_NON_OUTLINE);

    }
}
