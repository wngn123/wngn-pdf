package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.wngn.pdf.BootServer;

public class PanelHeader extends WangPanel implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;

    private static Point origin = new Point();
    private WangFrame frame;

    public PanelHeader(Color color, WangFrame frame) {
        super(color);
        this.frame = frame;
        init();
    }

    private void init() {
        this.setLayout(null);
        DoubleImageButton closeButton = new DoubleImageButton(ResourcesUtil.getCloseFFFFFFIcon(),
                ResourcesUtil.getClose35BF58Icon());
        closeButton.setBounds(WangFrame.FRAME_WIDTH - 35, 10, 15, 15);
        closeButton.addActionListener(new ExistAction());
        this.add(closeButton);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    class ExistAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                BootServer.fileForPid.delete();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            System.exit(0);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        origin.x = e.getX();
        origin.y = e.getY();
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

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = this.frame.getLocation();
        this.frame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
