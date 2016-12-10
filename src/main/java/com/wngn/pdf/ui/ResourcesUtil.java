/**
 * @by WangGang @2015年3月22日
 */
package com.wngn.pdf.ui;

import java.awt.Color;
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

    public static Color RGB35b558 = new Color(0x35, 0xb3, 0x58);
    public static Color RGB35bf58 = new Color(0x35, 0xbf, 0x58);
    public static Color RGB398dee = new Color(0x39, 0x8d, 0xee);
    public static Color RGBdddddd = new Color(0xdd, 0xdd, 0xdd);
    public static Color RGBcccccc = new Color(0xcc, 0xcc, 0xcc);
    public static Color RGB999999 = new Color(0x99, 0x99, 0x99);

    public static ImageIcon getIconByName(String name) {
        URL imgURL = ResourcesUtil.class.getResource("/icons/" + name + ".png");
        return new ImageIcon(imgURL);
    }

    public static ImageIcon getWngnCloseIcon() {
        URL imgURL = ResourcesUtil.class.getResource("/icons/close_1.png");
        return new ImageIcon(imgURL);
    }

    public static ImageIcon getCloseFFFFFFIcon() {
        URL imgURL = ResourcesUtil.class.getResource("/icons/close_ffffff.png");
        return new ImageIcon(imgURL);
    }

    public static ImageIcon getSettingIcon() {
        URL imgURL = ResourcesUtil.class.getResource("/icons/setting.png");
        return new ImageIcon(imgURL);
    }

    public static ImageIcon getClose000000Icon() {
        URL imgURL = ResourcesUtil.class.getResource("/icons/close_000000.png");
        return new ImageIcon(imgURL);
    }

    public static ImageIcon getClose35BF58Icon() {
        URL imgURL = ResourcesUtil.class.getResource("/icons/close_35bf58.png");
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
