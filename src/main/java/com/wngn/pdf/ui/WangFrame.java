/**
 * @by WangGang @2015年3月28日
 */
package com.wngn.pdf.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @title
 * @author Wang 2015年3月28日
 * @Date 2015年3月28日 上午11:41:09
 * @Version 1.0
 * @Description
 */
@SuppressWarnings("serial")
public class WangFrame extends JFrame {

    public static int HEADER_HEIGHT = 30;
    public static int NATIGATION_HEIGHT = 90;
    public static int FRAME_HEIGHT = 500;
    public static int FRAME_WIDTH = 800;

    protected JPanel header;
    protected JPanel navigation;
    protected PanelContent content;

    public PanelContent getContent() {
        return content;
    }

    public WangFrame() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
        Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
        int screenWidth = screenSize.width; // 获取屏幕的宽
        int screenHeight = screenSize.height; // 获取屏幕的高
        this.setLocation(screenWidth / 2 - 200, screenHeight / 2 - 150);// 设置窗口居中显示

        JPanel jp = (JPanel) this.getContentPane();
        jp.setOpaque(true);
        jp.setLayout(null); // 绝对定位布局
        this.header = new PanelHeader(ResourcesUtil.RGB35b558, this);
        this.navigation = new PanelNavigation(ResourcesUtil.RGB35b558, this);
        this.content = new PanelContent(ResourcesUtil.RGBdddddd);
        this.content.setWidthAndHeight(FRAME_WIDTH, FRAME_HEIGHT - HEADER_HEIGHT - NATIGATION_HEIGHT);
        this.content.init();
        this.content.drawing(new PanelContentIndex(ResourcesUtil.RGBdddddd));

        jp.add(this.header);
        jp.add(this.navigation);
        jp.add(this.content);
        this.header.setBounds(0, 0, FRAME_WIDTH, HEADER_HEIGHT);
        this.navigation.setBounds(0, HEADER_HEIGHT, FRAME_WIDTH, NATIGATION_HEIGHT);
        this.content.setBounds(0, HEADER_HEIGHT + NATIGATION_HEIGHT, FRAME_WIDTH,
                FRAME_HEIGHT - HEADER_HEIGHT - NATIGATION_HEIGHT);

        this.setUndecorated(true);// 去掉窗口的边框
        this.setVisible(true);

    }

}
