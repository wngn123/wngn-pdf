/**
 * @by WangGang @2015年3月22日
 */
package com.zzia.wngn.pdf.ui;

import java.net.URL;

import javax.swing.ImageIcon;

/**
 * @title
 * @author Wang 2015年3月22日
 * @Date 2015年3月22日 上午12:49:26
 * @Version 1.0
 * @Description
 */
public class ResourcesUtil {
    public static ImageIcon getWngnCloseIcon() {
        URL imgURL = ResourcesUtil.class.getResource("/icons/close_1.png");
        return new ImageIcon(imgURL);
    }

    public static ImageIcon getWngnCloseIcon_() {
        URL imgURL = ResourcesUtil.class.getResource("/icons/close_2.png");
        return new ImageIcon(imgURL);
    }

    public static ImageIcon getWngnFileIcon() {
        URL imgURL = ResourcesUtil.class.getResource("/icons/fldr_obj.gif");
        return new ImageIcon(imgURL);
    }

    public static ImageIcon getBackgroundIcon() {
        URL imgURL = ResourcesUtil.class.getResource("/icons/background.gif");
        return new ImageIcon(imgURL);
    }
}
