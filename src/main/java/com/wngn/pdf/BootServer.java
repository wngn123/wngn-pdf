package com.wngn.pdf;

import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wngn.common.Configuration;
import com.wngn.pdf.ui.WangFrame;
import com.wngn.util.ProcessUtil;

public class BootServer {

    protected static Logger logger = LoggerFactory.getLogger(BootServer.class);

    public static File fileForPid = null;

    public static void main(String[] args) {

        String filePath = BootServer.class.getResource("/").getPath() + "app.pid";
        filePath = Configuration.getInstance().getProperty("path.app.pid", filePath);
        logger.debug("filePath={}", filePath);
        if (StringUtils.isBlank(filePath)) {
            logger.error("wngn-pdf tool start failure! filePath is empty.");
            return;
        }
        fileForPid = new File(filePath);
        if (fileForPid.exists()) {
            logger.warn("server start error pid file : " + fileForPid + " exists");
        }
        int pid = ProcessUtil.saveProcessId(fileForPid);
        logger.info("wngn-pdf tool start success! pid={}", pid);
        new WangFrame();
        // fileForPid.delete();
    }

}
