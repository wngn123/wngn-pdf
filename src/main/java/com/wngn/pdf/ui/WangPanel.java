/**
 * @by WangGang @2015年3月28日
 */
package com.wngn.pdf.ui;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * @title
 * @author Wang 2015年3月28日
 * @Date 2015年3月28日 上午11:44:53
 * @Version 1.0
 * @Description
 */
public class WangPanel extends JPanel {

    private static final long serialVersionUID = 1841163778323439517L;

    protected int panelWidth;
    protected int panelHeight;

    public int getPanelWidth() {
        return panelWidth;
    }

    public void setPanelWidth(int panelWidth) {
        this.panelWidth = panelWidth;
    }

    public int getPanelHeight() {
        return panelHeight;
    }

    public void setPanelHeight(int panelHeight) {
        this.panelHeight = panelHeight;
    }

    public void setWidthAndHeight(int panelWidth, int panelHeight) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
    }

    public WangPanel() {
        this.setBackground(Color.BLUE);
    }

    public WangPanel(Color color) {
        this.setBackground(color);
    }
}
