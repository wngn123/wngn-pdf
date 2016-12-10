package com.wngn.pdf.ui;

import java.awt.Color;

import javax.swing.JPanel;

public class PanelContent extends WangPanel {

    private static final long serialVersionUID = 1L;
    private JPanel panel;

    public PanelContent(Color color) {
        super(color);
    }

    public void drawing(JPanel panel) {
        this.panel = panel;
        if (this.panel != null) {
            this.remove(panel);
        }
        panel.setBounds(0, 0, this.panelWidth, this.panelHeight);
        this.add(panel);

    }

    public void drawing(ContentType type) {
        if (this.panel != null) {
            this.remove(panel);
        }
        if (type.getCode() == ContentType.INDEX.getCode()) {
            this.panel = new PanelContentIndex(ResourcesUtil.RGBdddddd);
        } else if (type.getCode() == ContentType.SETTING.getCode()) {
            this.panel = new PanelContentSetting(ResourcesUtil.RGBdddddd);
        } else if (type.getCode() == ContentType.FORMAT.getCode()) {
            this.panel = new PanelContentFormat(ResourcesUtil.RGBdddddd);
        } else if (type.getCode() == ContentType.TEXT.getCode()) {
            this.panel = new PanelContentText(ResourcesUtil.RGBdddddd);
        } else if (type.getCode() == ContentType.PAGE.getCode()) {
            this.panel = new PanelContentPage(ResourcesUtil.RGBdddddd);
        }
        this.panel.setBounds(0, 0, this.panelWidth, this.panelHeight);
        this.add(panel);
        this.repaint();

    }

    public void init() {
        this.setSize(this.panelWidth, this.panelHeight);
        this.setLayout(null);
    }

}
