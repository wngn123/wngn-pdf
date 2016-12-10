package com.wngn.pdf.ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class ScaleImageButton extends ImageButton {

    private static final long serialVersionUID = 4485963688763083140L;

    protected ImageIcon icon;

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 400, 300);
        ScaleImageButton button = new ScaleImageButton(ResourcesUtil.getCloseFFFFFFIcon());
        button.setBackground(ResourcesUtil.RGB35b558);
        button.setBounds(10, 10, 200, 100);
        jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(button);
        jframe.getContentPane().setBackground(ResourcesUtil.RGB35b558);
        jframe.setVisible(true);
    }

    public ScaleImageButton(ImageIcon icon) {
        setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
        setIcon(new ScaleIcon(icon));
        this.setBackground(ResourcesUtil.RGB35b558);
        this.addMouseListener(this);
        this.setIconTextGap(0);
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
    }
}
