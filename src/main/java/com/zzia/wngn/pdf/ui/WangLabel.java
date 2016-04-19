package com.zzia.wngn.pdf.ui;

import java.awt.Font;
import javax.swing.JLabel;

public class WangLabel extends JLabel {

    private static final long serialVersionUID = 4489767231914025028L;

    public static WangLabel getLable(String text) {
        WangLabel label = new WangLabel();
        label.setText(text);
        label.setFont(new Font("宋体", Font.PLAIN, 12));
        return label;
    }

}
