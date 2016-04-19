/**
 * @by WangGang @2015年3月28日
 */
package com.zzia.wngn.pdf.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

    public WangFrame() {
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
        Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
        int screenWidth = screenSize.width; // 获取屏幕的宽
        int screenHeight = screenSize.height; // 获取屏幕的高
        this.setLocation(screenWidth / 2 - 200, screenHeight / 2 - 150);// 设置窗口居中显示
        ImageIcon bg = ResourcesUtil.getBackgroundIcon();
        JLabel label = new JLabel(bg);
        label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel) this.getContentPane();
        jp.setOpaque(false);// 设置透明 
        jp.addMouseListener(new WangMouseListener(jp, this));
        this.setUndecorated(true);// 去掉窗口的边框
        this.setVisible(true);

    }

    public void reShow() {
        this.setVisible(true);
    }

    class WangMouseListener implements MouseListener {

        private JPanel jpanel;
        private WangFrame frame;

        public WangMouseListener(JPanel jpanel, WangFrame frame) {
            super();
            this.jpanel = jpanel;
            this.frame = frame;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            this.jpanel.setOpaque(true);
            this.jpanel.setLayout(new GridLayout(2, 1));
            this.jpanel.add(new PanelTop(Color.BLUE, frame));
            this.jpanel.add(new PanelContent());
            this.jpanel.removeMouseListener(this);
            reShow();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {
            this.jpanel.setOpaque(false);
        }

    }

}
