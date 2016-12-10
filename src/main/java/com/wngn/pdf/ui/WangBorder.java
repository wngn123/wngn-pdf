package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.border.AbstractBorder;

public class WangBorder extends AbstractBorder {

    private static final long serialVersionUID = 7823480715950252187L;
    protected Color color;
    protected Graphics graphics;

    private boolean borderLeft = true;
    private boolean borderRight = true;
    private boolean borderTop = true;
    private boolean borderButtom = true;

    public WangBorder(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void refush(Component c) {
        paintBorder(c, this.graphics, 0, 0, c.getWidth(), c.getHeight());
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Color oldColor = g.getColor();
        this.graphics = g;
        // g.dispose();
        g.translate(x, y);
        g.setColor(this.color);
        // 左(0,0)-->(0,y)
        if (borderLeft) {
            g.drawLine(0, 0, 0, height - 1);
        }
        // 上(0,0)-->(x,0)
        if (borderTop) {
            g.drawLine(0, 0, width - 1, 0);
        }

        // 右(x,0)-->(x,y)
        if (borderRight) {
            g.drawLine(width - 1, 0, width - 1, height - 1);
        }

        // / 下(0,y)-->(x,y)
        if (borderButtom) {
            g.drawLine(0, height - 1, width - 1, height - 1);
        }

        g.translate(-x, -y);
        g.setColor(oldColor);
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 400, 300);
        // jframe.setUndecorated(true);// 去掉窗口的边框
        WangButton button = WangButton.getForbidButon("渠道");
        button.setBorder(new WangBorder(Color.RED).setBorderShow(true, true, true, false));
        button.setMargin(10, 12);
        jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(button);

        jframe.getContentPane().setBackground(Color.WHITE);
        jframe.setVisible(true);
    }

    public WangBorder setBorderShow(boolean borderLeft, boolean borderRight, boolean borderTop, boolean borderButtom) {
        this.borderLeft = borderLeft;
        this.borderRight = borderRight;
        this.borderTop = borderTop;
        this.borderButtom = borderButtom;
        return this;
    }
}
