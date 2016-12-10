package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class DoubleImageButton extends ImageButton {

    private static final long serialVersionUID = 4485963688763083140L;

    protected ImageIcon enteredIcon;
    protected ImageIcon normalIcon;

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
        DoubleImageButton button = new DoubleImageButton(ResourcesUtil.getCloseFFFFFFIcon(),
                ResourcesUtil.getClose35BF58Icon());
        button.setBackground(ResourcesUtil.RGB35b558);
        button.setBounds(10, 10, 15, 15);
        jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(button);
        jframe.getContentPane().setBackground(ResourcesUtil.RGB35b558);
        jframe.setVisible(true);
    }

    public DoubleImageButton(ImageIcon normalIcon, ImageIcon enteredIcon) {
        this.normalIcon = normalIcon;
        this.enteredIcon = enteredIcon;
        setSize(normalIcon.getImage().getWidth(null), normalIcon.getImage().getHeight(null));
        setIcon(normalIcon);
        this.setBackground(ResourcesUtil.RGB35b558);
        this.addMouseListener(this);
        this.setIconTextGap(0);
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    public DoubleImageButton(ImageIcon icon) {
        this.normalIcon = icon;
        setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
        setIcon(icon);
        this.setBackground(Color.BLUE);
        this.addMouseListener(this);
        this.setIconTextGap(0);
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
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
