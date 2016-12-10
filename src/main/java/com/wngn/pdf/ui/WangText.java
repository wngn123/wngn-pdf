package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class WangText extends JTextField implements MouseListener {

    private static final long serialVersionUID = -4239693009477864419L;

    private WangBorder border;
    private boolean mouse = true;
    private int marginLeft;
    private int marginTop;
    private int textWidth;
    private int textHeight;

    private void initBounds() {
        this.marginLeft = 0;
        this.marginTop = 0;
        if (textWidth == 0) {
            this.textWidth = 70;
        }
        if (textHeight == 0) {
            this.textHeight = 28;
        }
        this.setBounds(this.marginLeft, this.marginTop, this.textWidth, this.textHeight);
        this.setFont(new Font("宋体", Font.PLAIN, 12));
        border = new WangBorder(new Color(0xe7f1f7));
        this.setBorder(border);
        this.setBackground(Color.gray);
        this.addMouseListener(this);
        this.setForeground(Color.WHITE);
    }

    public static WangText getTextField() {
        WangText textField = new WangText();
        textField.initBounds();
        textField.setText("");
        return textField;
    }

    public static WangText getTextField(int left, int top, int width, int height) {
        WangText textField = new WangText();
        textField.initBounds();
        textField.setText("");
        textField.setBounds(left, top, width, height);
        return textField;
    }

    public static WangText getSmallTextField(int left, int top, int width) {
        WangText textField = new WangText();
        textField.setTextHeight(20);
        textField.initBounds();
        textField.setFont(new Font("宋体", Font.PLAIN, 12));
        textField.setText(" ");
        textField.setBounds(left, top, width);
        return textField;
    }

    public static WangText getMiddleTextField(int left, int top, int width) {
        WangText textField = new WangText();
        textField.setTextHeight(25);
        textField.initBounds();
        textField.setFont(new Font("宋体", Font.PLAIN, 16));
        textField.setText(" ");
        textField.setBounds(left, top, width);
        return textField;
    }

    public static WangText getBigTextField(int left, int top, int width) {
        WangText textField = new WangText();
        textField.setTextHeight(30);
        textField.initBounds();
        textField.setFont(new Font("宋体", Font.PLAIN, 20));
        textField.setText(" ");
        textField.setBounds(left, top, width);
        return textField;
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 400, 300);
        // jframe.setUndecorated(true);// 去掉窗口的边框
        WangText homeField = WangText.getBigTextField(10, 10, 100);
        homeField.setText("王刚");
        jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(homeField);
        jframe.getContentPane().setBackground(Color.GRAY);
        jframe.setVisible(true);
    }

    public void setBounds(int left, int top, int width) {
        this.marginLeft = left;
        this.marginTop = top;
        this.textWidth = width;
        this.setBounds(this.marginLeft, this.marginTop, this.textWidth, this.textHeight);
    }

    public void setMargin(int left, int top) {
        this.marginLeft = left;
        this.marginTop = top;
        this.setBounds(this.marginLeft, this.marginTop, this.textWidth, this.textHeight);
    }

    public void setBounds(int width, int height) {
        this.textWidth = width;
        this.textHeight = height;
        this.setBounds(this.marginLeft, this.marginTop, this.textWidth, this.textHeight);
    }

    public void setWidth(int width) {
        this.textWidth = width;
        this.setBounds(this.marginLeft, this.marginTop, this.textWidth, this.textHeight);
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

    public int getTextWidth() {
        return textWidth;
    }

    public void setTextWidth(int textWidth) {
        this.textWidth = textWidth;
    }

    public int getTextHeight() {
        return textHeight;
    }

    public void setTextHeight(int textHeight) {
        this.textHeight = textHeight;
    }

    public void setBoderColor(Color color) {

        if (color == null) {
            this.setBorder(new EmptyBorder(0, 0, 0, 0));
        } else {
            this.setBorder(new WangBorder(color));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (mouse) {
            this.border.setColor(Color.blue);
            this.border.refush(this);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (mouse) {
            this.border.setColor(new Color(0xe7f1f7));
            this.border.refush(this);
        }
    }

    public void setBorderShow(boolean borderLeft, boolean borderRight, boolean borderTop, boolean borderButtom) {
        this.border.setBorderShow(borderLeft, borderRight, borderTop, borderButtom);
    }

    public void setMouse(boolean mouse) {
        this.mouse = mouse;
    }
}
