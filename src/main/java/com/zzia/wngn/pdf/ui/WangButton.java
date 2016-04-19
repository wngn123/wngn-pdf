package com.zzia.wngn.pdf.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class WangButton extends JButton implements MouseListener {
    private static final long serialVersionUID = 1560255135421961477L;
    public static Color COLOR_A = new Color(0xe7f1f7);
    public static Color COLOR_B = new Color(0xf7f1f7);
    private boolean active;
    private int marginLeft;
    private int marginTop;
    private int width;
    private int height;

    private Color color;

    private void initBounds() {
        this.marginLeft = 0;
        this.marginTop = 0;
        this.width = 50;
        this.height = 28;
        this.color = new Color(0xe7f1f7);
        this.setBackground(this.color);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setFont(new Font("宋体", Font.PLAIN, 12));
        this.addMouseListener(this);
        this.setBounds(this.marginLeft, this.marginTop, this.width, this.height);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static WangButton getActiveButon(String name) {
        WangButton button = new WangButton();
        button.setText(name);
        button.initBounds();
        return button;
    }

    public static WangButton getForbidButon() {
        WangButton button = new WangButton();
        button.initBounds();
        return button;
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 400, 300);
        // jframe.setUndecorated(true);// 去掉窗口的边框
        WangButton button = WangButton.getForbidButon();
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("999999999999999");

            }
        });
        jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(button);

        jframe.getContentPane().setBackground(Color.WHITE);
        jframe.setVisible(true);
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
        this.setBackground(COLOR_B);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(this.color);
    }

}
