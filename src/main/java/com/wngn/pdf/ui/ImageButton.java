package com.wngn.pdf.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public abstract class ImageButton extends JButton implements MouseListener {

    private static final long serialVersionUID = -4623261929892002496L;

    private ClickAction action;
    protected int buttonWidth;
    protected int buttonHeight;

    public int getButtonWidth() {
        return buttonWidth;
    }

    public int getButtonHeight() {
        return buttonHeight;
    }

    public void setClickAction(ClickAction action) {
        this.action = action;
    }

    public void setWidthAndHeight(int buttonWidth, int buttonHeight) {
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (action != null) {
            action.click();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
