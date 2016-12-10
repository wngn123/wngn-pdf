package com.wngn.pdf.ui;

import java.awt.Color;

public class PanelNavigation extends WangPanel {

    private static final long serialVersionUID = 1L;

    private WangFrame frame;

    public PanelNavigation(Color color, WangFrame frame) {
        super(color);
        this.frame = frame;
        init();
    }

    private void init() {
        this.setLayout(null);

        int blockWidth = WangFrame.NATIGATION_HEIGHT + WangFrame.NATIGATION_HEIGHT / 2;
        PanelBlock blockFormat = new PanelBlock(ResourcesUtil.RGB35b558, ResourcesUtil.RGB35bf58, this);
        ImageBlock imageFormat = new ImageBlock(ResourcesUtil.getIconByName("format_35b558"),
                ResourcesUtil.getIconByName("format_35bf58"), this.frame, ContentType.FORMAT);
        blockFormat.setImageBlock(imageFormat);
        blockFormat.setWidthAndHeight(blockWidth, WangFrame.NATIGATION_HEIGHT);
        blockFormat.init();
        blockFormat.setBounds(20, 0, blockWidth, WangFrame.NATIGATION_HEIGHT);
        this.add(blockFormat);

        PanelBlock blockText = new PanelBlock(ResourcesUtil.RGB35b558, ResourcesUtil.RGB35bf58, this);
        ImageBlock imageText = new ImageBlock(ResourcesUtil.getIconByName("text_35b558"),
                ResourcesUtil.getIconByName("text_35bf58"), this.frame, ContentType.TEXT);
        blockText.setImageBlock(imageText);
        blockText.setWidthAndHeight(blockWidth, WangFrame.NATIGATION_HEIGHT);
        blockText.init();
        blockText.setBounds(20 + blockWidth + 30, 0, blockWidth, WangFrame.NATIGATION_HEIGHT);
        this.add(blockText);

        PanelBlock blockPage = new PanelBlock(ResourcesUtil.RGB35b558, ResourcesUtil.RGB35bf58, this);
        ImageBlock imagePage = new ImageBlock(ResourcesUtil.getIconByName("page_35b558"),
                ResourcesUtil.getIconByName("page_35bf58"), this.frame, ContentType.PAGE);
        blockPage.setImageBlock(imagePage);
        blockPage.setWidthAndHeight(blockWidth, WangFrame.NATIGATION_HEIGHT);
        blockPage.init();
        blockPage.setBounds(20 + blockWidth * 2 + 60, 0, blockWidth, WangFrame.NATIGATION_HEIGHT);
        this.add(blockPage);

        PanelBlock blockSetting = new PanelBlock(ResourcesUtil.RGB35b558, ResourcesUtil.RGB35bf58, this);
        ImageBlock imageSetting = new ImageBlock(ResourcesUtil.getIconByName("setting_35b558"),
                ResourcesUtil.getIconByName("setting_35bf58"), this.frame, ContentType.SETTING);
        blockSetting.setImageBlock(imageSetting);
        blockSetting.setWidthAndHeight(blockWidth, WangFrame.NATIGATION_HEIGHT);
        blockSetting.init();
        blockSetting.setBounds(20 + blockWidth * 3 + 90, 0, blockWidth, WangFrame.NATIGATION_HEIGHT);
        this.add(blockSetting);

    }

}
