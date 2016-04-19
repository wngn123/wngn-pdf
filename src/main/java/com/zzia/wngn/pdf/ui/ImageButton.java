package com.zzia.wngn.pdf.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class ImageButton extends JButton implements MouseListener {

    private static final long serialVersionUID = 4485963688763083140L;
    private ImageIcon enteredIcon;
    private ImageIcon normalIcon;

    public ImageIcon getEnteredIcon() {
        return enteredIcon;
    }

    public void setEnteredIcon(ImageIcon enteredIcon) {
        this.enteredIcon = enteredIcon;
    }

    public ImageIcon getNormalIcon() {
        return normalIcon;
    }

    public void setNormalIcon(ImageIcon normalIcon) {
        this.normalIcon = normalIcon;
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 400, 300);
        ImageButton button = new ImageButton(ResourcesUtil.getWngnCloseIcon_(), ResourcesUtil.getWngnCloseIcon());
        button.setBounds(10, 10, 20, 20);
        jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(button);
        jframe.getContentPane().setBackground(Color.BLUE);
        jframe.setVisible(true);
    }

    public ImageButton(ImageIcon normalIcon, ImageIcon enteredIcon) {
        this.normalIcon = normalIcon;
        this.enteredIcon = enteredIcon;
        setSize(normalIcon.getImage().getWidth(null), normalIcon.getImage().getHeight(null));
        setIcon(normalIcon);
        this.setBackground(Color.BLUE);
        this.addMouseListener(this);
        this.setIconTextGap(0);
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    public ImageButton(ImageIcon icon) {
        this.normalIcon = icon;
        setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
        setIcon(icon);
        this.setBackground(Color.BLUE);
        this.addMouseListener(this);
        this.setIconTextGap(0);
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
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
        if (this.enteredIcon != null) {
            this.setIcon(enteredIcon);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (this.enteredIcon != null) {
            this.setIcon(normalIcon);
        }
    }

}
