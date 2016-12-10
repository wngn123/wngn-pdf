package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class WangButton extends JButton implements MouseListener {
    private static final long serialVersionUID = 1560255135421961477L;
    private boolean active;
    private int marginLeft;
    private int marginTop;
    private int buttonWidth;
    private int buttonHeight;

    private Color color;

    private void initBounds() {
        if (this.buttonWidth == 0) {
            this.buttonWidth = 50;
        }
        if (this.buttonHeight == 0) {
            this.buttonHeight = 28;
        }
        this.color = active ? ResourcesUtil.RGB35b558 : ResourcesUtil.RGB999999;
        this.setBackground(this.color);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setFont(new Font("宋体", Font.PLAIN, 12));
        this.addMouseListener(this);
        this.setBounds(this.marginLeft, this.marginTop, this.buttonWidth, this.buttonHeight);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static WangButton getActiveButon(int width, int height, String name) {
        WangButton button = new WangButton();
        button.setText(name);
        button.active = true;
        button.setButtonWidth(width);
        button.setButtonHeight(height);
        button.initBounds();
        return button;
    }

    public static WangButton getActiveButon(int left, int top, int width, int height, String name) {
        WangButton button = new WangButton();
        button.setText(name);
        button.active = true;
        button.setMarginLeft(left);
        button.setMarginTop(top);
        button.setButtonWidth(width);
        button.setButtonHeight(height);
        button.initBounds();
        return button;
    }

    public static WangButton getSmallActiveButon(int left, int top, String name) {
        WangButton button = new WangButton();
        button.setText(name);
        button.active = true;
        button.setMarginLeft(left);
        button.setMarginTop(top);
        button.setButtonWidth(name.length() * 21);
        button.setButtonHeight(20);
        button.initBounds();
        button.setFont(new Font("宋体", Font.PLAIN, 12));
        return button;
    }

    public static WangButton getMiddleActiveButon(int left, int top, String name) {
        WangButton button = new WangButton();
        button.setText(name);
        button.active = true;
        button.setMarginLeft(left);
        button.setMarginTop(top);
        button.setButtonWidth(name.length() * 25);
        button.setButtonHeight(25);
        button.initBounds();
        button.setFont(new Font("宋体", Font.PLAIN, 16));
        return button;
    }

    public static WangButton getBigActiveButon(int left, int top, String name) {
        WangButton button = new WangButton();
        button.setText(name);
        button.active = true;
        button.setMarginLeft(left);
        button.setMarginTop(top);
        button.setButtonWidth(name.length() * 29);
        button.setButtonHeight(30);
        button.initBounds();
        button.setFont(new Font("宋体", Font.PLAIN, 20));
        return button;
    }

    public static WangButton getActiveButon(String name) {
        WangButton button = new WangButton();
        button.setText(name);
        button.active = true;
        button.initBounds();
        return button;
    }

    public static WangButton getForbidButon(int width, int height, String name) {
        WangButton button = new WangButton();
        button.setText(name);
        button.active = false;
        button.setButtonWidth(width);
        button.setButtonHeight(height);
        button.initBounds();
        return button;
    }

    public static WangButton getForbidButon(String name) {
        WangButton button = new WangButton();
        button.setText(name);
        button.active = false;
        button.initBounds();
        return button;
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 400, 300);
        // jframe.setUndecorated(true);// 去掉窗口的边框
        WangButton small = WangButton.getSmallActiveButon(10, 10, "测试");
        WangButton middle = WangButton.getMiddleActiveButon(10, 60, "测试");
        WangButton big = WangButton.getBigActiveButon(10, 120, "测试");
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
        this.setBounds(this.marginLeft, this.marginTop, this.buttonWidth, this.buttonHeight);
    }

    public void setBounds(int width, int height) {
        this.buttonWidth = width;
        this.buttonHeight = height;
        this.setBounds(this.marginLeft, this.marginTop, this.buttonWidth, this.buttonHeight);
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

    public int getButtonWidth() {
        return buttonWidth;
    }

    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public int getButtonHeight() {
        return buttonHeight;
    }

    public void setButtonHeight(int buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (active) {
            this.setBackground(ResourcesUtil.RGB35bf58);
        } else {
            this.setBackground(ResourcesUtil.RGB999999);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (active) {
            this.setBackground(ResourcesUtil.RGB35bf58);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (active) {
            this.setBackground(this.color);
        }
    }

}
