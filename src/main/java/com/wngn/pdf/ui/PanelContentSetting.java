package com.wngn.pdf.ui;

import java.awt.Color;

public class PanelContentSetting extends WangPanel {

    private static final long serialVersionUID = -8040978742445218390L;

    public PanelContentSetting() {
        super(Color.GRAY);
        init();
    }

    public PanelContentSetting(Color color) {
        super(color);
        init();
    }

    public void init() {
        this.setSize(400, 200);
        this.setLayout(null);

    }

}
