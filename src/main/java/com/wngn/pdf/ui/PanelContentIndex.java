package com.wngn.pdf.ui;

import java.awt.Color;
import javax.swing.JLabel;

public class PanelContentIndex extends WangPanel {

    private static final long serialVersionUID = -8040978742445218390L;

    public PanelContentIndex(Color color) {
        super(color);
        init();
    }

    public void init() {
        this.setSize(this.panelWidth, this.panelHeight);
        this.setLayout(null);

        int labelHeight = 0;
        int lineHeight = 10;
        int marginLeft = 50;
        int marginTop = 50;
        JLabel label = WangLabel.getBigLable("【PDF电子书自动添加目录工具，一键为PDF添加完整目录】", marginLeft, marginTop);
        labelHeight = label.getHeight();
        this.add(label);
        marginTop = marginTop + labelHeight + lineHeight;
        label = WangLabel.getBigLable("【文本生成书签】即将目录拷入TXT文档，根据该文档向PDF添加目录", marginLeft, marginTop);
        this.add(label);

        marginTop = marginTop + labelHeight + lineHeight;
        label = WangLabel.getBigLable("（亚马逊一般会有图书的目录，软件已亚马逊的目录为准。）", marginLeft, marginTop);
        this.add(label);

        marginTop = marginTop + labelHeight + lineHeight;
        label = WangLabel.getBigLable("【页码生成书签】即根据PDF实际页码生成书签，每一页都有书签对应。", marginLeft, marginTop);
        this.add(label);

        marginTop = marginTop + labelHeight + lineHeight;
        label = WangLabel.getBigLable("【首页位置】pdf封面对应的页数   【 目录位置】pdf目录对应的页数", marginLeft, marginTop);
        this.add(label);

        marginTop = marginTop + labelHeight + lineHeight;
        label = WangLabel.getBigLable("【最大页数】pdf内容最大页码     【页码偏移】pdf内容页码和页数差值", marginLeft, marginTop);
        this.add(label);

    }

}
