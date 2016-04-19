package com.zzia.wngn.pdf.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UIMain {

    protected static Logger logger = LoggerFactory.getLogger(UIMain.class);

    public static void main(String[] args) {
        logger.info("启动");
        new WangFrame();
    }
}
