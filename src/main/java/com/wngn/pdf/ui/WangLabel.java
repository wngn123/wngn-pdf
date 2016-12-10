package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WangLabel extends JLabel {

    private static final long serialVersionUID = 4489767231914025028L;
    public static final int FONT_SMALL = 12;
    public static final int FONT_MIDDLE = 16;
    public static final int FONT_BIG = 20;

    public static WangLabel getLable(String text, int fontSize) {
        WangLabel label = new WangLabel();
        label.setText(text);
        label.setFont(new Font("宋体", Font.PLAIN, fontSize));
        return label;
    }

    public static WangLabel getLable(String text, int fontSize, int x, int y) {
        WangLabel label = new WangLabel();
        label.setText(text);
        label.setFont(new Font("宋体", Font.PLAIN, fontSize));
        label.setBounds(x, y, 200, 100);
        return label;

    }

    public static WangLabel getSmallLable(String text, int x, int y) {
        WangLabel label = new WangLabel();
        label.setText(text);
        label.setFont(new Font("宋体", Font.PLAIN, FONT_SMALL));
        label.setBounds(x, y, text.length() * 13, 20);
        return label;

    }

    public static WangLabel getMiddleLable(String text, int x, int y) {
        WangLabel label = new WangLabel();
        label.setText(text);
        label.setFont(new Font("宋体", Font.PLAIN, FONT_MIDDLE));
        label.setBounds(x, y, text.length() * 17, 25);
        return label;

    }

    public static WangLabel getBigLable(String text, int x, int y) {
        WangLabel label = new WangLabel();
        label.setText(text);
        label.setFont(new Font("宋体", Font.PLAIN, FONT_BIG));
        label.setBounds(x, y, text.length() * 21, 30);
        return label;

    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 400, 300);
        JLabel big = WangLabel.getBigLable("便宜便宜便宜便宜", 10, 10);
        big.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        JLabel middle = WangLabel.getMiddleLable("便宜便宜便宜", 10, 60);
        middle.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        JLabel small = WangLabel.getSmallLable("便宜便宜", 10, 140);
        small.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(big);
        jframe.getContentPane().add(middle);
        jframe.getContentPane().add(small);
        jframe.getContentPane().setBackground(ResourcesUtil.RGBdddddd);
        jframe.setVisible(true);
    }

}
