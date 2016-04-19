package com.zzia.wngn.pdf.ui;

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
    private int width;
    private int height;

    private void initBounds() {
        this.marginLeft = 0;
        this.marginTop = 0;
        this.width = 70;
        this.height = 28;
        this.setBounds(this.marginLeft, this.marginTop, this.width, this.height);
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

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 400, 300);
        // jframe.setUndecorated(true);// 去掉窗口的边框
        WangText homeField = WangText.getTextField();
        homeField.setText("王刚");
        homeField.setBounds(20, 20, 120);
        jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(homeField);
        jframe.getContentPane().setBackground(Color.GRAY);
        jframe.setVisible(true);
    }

    public void setBounds(int left, int top, int width) {
        this.marginLeft = left;
        this.marginTop = top;
        this.width = width;
        this.setBounds(this.marginLeft, this.marginTop, this.width, this.height);
    }

    public void setMargin(int left, int top) {
        this.marginLeft = left;
        this.marginTop = top;
        this.setBounds(this.marginLeft, this.marginTop, this.width, this.height);
    }

    public void setBounds(int width, int height) {
        this.width = width;
        this.height = height;
        this.setBounds(this.marginLeft, this.marginTop, this.width, this.height);
    }

    public void setWidth(int width) {
        this.width = width;
        this.setBounds(this.marginLeft, this.marginTop, this.width, this.height);
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
        // this.setBorder(new WangBorder(Color.blue));
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
        // this.setBorder(new WangBorder(new Color(0xe7f1f7)));
    }

    public void setBorderShow(boolean borderLeft, boolean borderRight, boolean borderTop, boolean borderButtom) {
        this.border.setBorderShow(borderLeft, borderRight, borderTop, borderButtom);
    }

    public void setMouse(boolean mouse) {
        this.mouse = mouse;
    }
}
