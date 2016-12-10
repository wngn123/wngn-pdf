package com.wngn.pdf.ui;

import java.awt.Color;
import javax.swing.JPanel;

public class PanelBlock extends WangPanel {

    private static final long serialVersionUID = 1L;

    private ImageBlock imageBlock;
    protected Color enteredColor;
    protected Color normalColor;

    private int width;
    private int height;

    public PanelBlock(Color normalColor, Color enteredColor, JPanel parent) {
        this.normalColor = normalColor;
        this.enteredColor = enteredColor;
    }

    public PanelBlock(Color normalColor, Color enteredColor, int width, int height, ImageBlock imageBlock) {
        this.normalColor = normalColor;
        this.enteredColor = enteredColor;
        this.width = width;
        this.height = height;
        this.imageBlock = imageBlock;
        init();
    }

    public void setWidthAndHeight(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setImageBlock(ImageBlock imageBlock) {
        this.imageBlock = imageBlock;
    }

    public void init() {
        this.setLayout(null);
        this.setBackground(normalColor);
        imageBlock.setPanel(this);
        int offsetWidth = (this.width - imageBlock.getWidth()) / 2;
        int offsetHeight = (this.height - imageBlock.getHeight()) / 2;
        imageBlock.setBounds(offsetWidth, offsetHeight, imageBlock.getWidth(), imageBlock.getHeight());
        this.add(imageBlock);
    }

}
