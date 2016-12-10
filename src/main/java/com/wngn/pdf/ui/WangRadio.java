package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class WangRadio extends JRadioButton {
    private static final long serialVersionUID = 1560255135421961477L;
    private int marginLeft;
    private int marginTop;
    private int radioWidth;
    private int radioHeight;

    private void initBounds() {
        if (this.radioWidth == 0) {
            this.radioWidth = 50;
        }
        if (this.radioHeight == 0) {
            this.radioHeight = 28;
        }
        this.setText("");
        this.setBackground(Color.GRAY);
        this.setFont(new Font("宋体", Font.PLAIN, 12));
        this.setBounds(this.marginLeft, this.marginTop, this.radioWidth, this.radioHeight);
    }

    public static WangRadio getActiveButon(int left, int top, int width, int height, String name) {

        WangRadio radio = new WangRadio();
        radio.setMarginLeft(left);
        radio.setMarginTop(top);
        radio.setRadioWidth(width);
        radio.setRadioHeight(height);
        radio.initBounds();
        radio.setFont(new Font("宋体", Font.PLAIN, 12));
        radio.setText(name);

        // pageRadioButton = new JRadioButton("页码生成书签");// 创建单选按钮

        return radio;
    }

    public static WangRadio getSmaillRadio(int left, int top, String name) {
        WangRadio radio = new WangRadio();
        radio.setMarginLeft(left);
        radio.setMarginTop(top);
        radio.setRadioWidth(name.length() * 17);
        radio.setRadioHeight(20);
        radio.initBounds();
        radio.setFont(new Font("宋体", Font.PLAIN, 12));
        radio.setText(name);
        return radio;
    }

    public static WangRadio getMiddleRadio(int left, int top, String name) {
        WangRadio radio = new WangRadio();
        radio.setMarginLeft(left);
        radio.setMarginTop(top);
        radio.setRadioWidth(name.length() * 21);
        radio.setRadioHeight(25);
        radio.initBounds();
        radio.setFont(new Font("宋体", Font.PLAIN, 16));
        radio.setText(name);
        return radio;
    }

    public static WangRadio getBigRadio(int left, int top, String name) {
        WangRadio radio = new WangRadio();
        radio.setMarginLeft(left);
        radio.setMarginTop(top);
        radio.setRadioWidth(name.length() * 26);
        radio.setRadioHeight(30);
        radio.initBounds();
        radio.setFont(new Font("宋体", Font.PLAIN, 21));
        radio.setText(name);
        return radio;
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.setBounds(100, 100, 400, 300);
        WangRadio small = WangRadio.getSmaillRadio(10, 60, "页码生成书签");
        WangRadio middle = WangRadio.getMiddleRadio(100, 120, "页码生成书签");
        WangRadio big = WangRadio.getBigRadio(30, 180, "页码生成书签");
        jframe.getContentPane().setLayout(null);

        jframe.getContentPane().add(small);
        jframe.getContentPane().add(middle);
        jframe.getContentPane().add(big);

        jframe.getContentPane().setBackground(Color.WHITE);
        jframe.setVisible(true);
    }

    public void setMargin(int left, int top) {
        this.marginLeft = left;
        this.marginTop = top;
        this.setBounds(this.marginLeft, this.marginTop, this.radioWidth, this.radioHeight);
    }

    public void setBounds(int width, int height) {
        this.radioWidth = width;
        this.radioHeight = height;
        this.setBounds(this.marginLeft, this.marginTop, this.radioWidth, this.radioHeight);
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public int getRadioWidth() {
        return radioWidth;
    }

    public void setRadioWidth(int radioWidth) {
        this.radioWidth = radioWidth;
    }

    public int getRadioHeight() {
        return radioHeight;
    }

    public void setRadioHeight(int radioHeight) {
        this.radioHeight = radioHeight;
    }

}
