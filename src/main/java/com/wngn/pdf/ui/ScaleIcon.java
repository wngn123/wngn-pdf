package com.wngn.pdf.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ScaleIcon implements Icon {

    private Icon icon = null;

    public ScaleIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public int getIconHeight() {
        return icon.getIconHeight();
    }

    @Override
    public int getIconWidth() {
        return icon.getIconWidth();
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        float wid = c.getWidth();
        float hei = c.getHeight();
        int iconWid = icon.getIconWidth();
        int iconHei = icon.getIconHeight();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.scale(wid / iconWid, hei / iconHei);
        icon.paintIcon(c, g2d, 0, 0);
    }

    public static void main(String[] args) {
        ScaleIcon icon = new ScaleIcon(ResourcesUtil.getIconByName("file"));
        JLabel label = new JLabel(icon);
        JFrame frame = new JFrame();
        frame.getContentPane().add(label, BorderLayout.CENTER);
        // frame.getContentPane().add(new JButton("click"),BorderLayout.NORTH);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}