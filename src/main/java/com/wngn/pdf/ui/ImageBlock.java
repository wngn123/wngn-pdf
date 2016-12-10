package com.wngn.pdf.ui;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class ImageBlock extends DoubleImageButton {

    private static final long serialVersionUID = 4485963688763083140L;

    private PanelBlock panel;
    private WangFrame frame;
    private ContentType type;

    public ImageBlock(ImageIcon normalIcon, ImageIcon enteredIcon, WangFrame frame, ContentType type) {
        super(normalIcon, enteredIcon);
        this.frame = frame;
        this.type = type;
    }

    public PanelBlock getPanel() {
        return panel;
    }

    public void setPanel(PanelBlock panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.frame.getContent().drawing(type);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (this.enteredIcon != null) {
            this.setIcon(enteredIcon);
        }
        if (this.panel != null) {
            this.panel.setBackground(this.panel.enteredColor);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (this.enteredIcon != null) {
            this.setIcon(normalIcon);
        }
        if (this.panel != null) {
            this.panel.setBackground(this.panel.normalColor);
        }
    }

}
