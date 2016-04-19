package com.zzia.wngn.pdf.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

public class PanelTop extends WangPanel implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    private static Point origin = new Point();
    private WangFrame frame;

    public PanelTop(Color color, WangFrame frame) {
        super(color);
        this.frame = frame;
        init();
    }

    private void init() {
        this.setLayout(null);
        ImageButton imageButton = new ImageButton(ResourcesUtil.getWngnCloseIcon_(), ResourcesUtil.getWngnCloseIcon());
        imageButton.setBounds(375, 5, 20, 20);
        imageButton.addActionListener(new ExistAction());
        this.add(imageButton);
        int height = 18;
        int size = 12;
        int top = 10;
        int top_ = 4;
        JLabel label = new JLabel();
        label.setText("【PDF电子书自动添加目录工具，一键为PDF添加完整目录】");
        label.setBounds(10, top, 380, height);
        label.setFont(new Font("宋体", Font.PLAIN, size));
        this.add(label);

        top = top + height + top_;
        label = new JLabel();
        label.setText("【文本生成书签】即将目录拷入TXT文档，根据该文档向PDF添加目录");
        label.setBounds(10, top, 380, height);
        label.setFont(new Font("宋体", Font.PLAIN, size));
        this.add(label);
        top = top + height + top_;
        label = new JLabel();
        label.setText("（亚马逊一般会有图书的目录，软件已亚马逊的目录为准。）");
        label.setBounds(10, top, 380, height);
        label.setFont(new Font("宋体", Font.PLAIN, size));
        this.add(label);
        top = top + height + top_;
        label = new JLabel();
        label.setText("【页码生成书签】即根据PDF实际页码生成书签，每一页都有书签对应。");
        label.setBounds(10, top, 380, height);
        label.setFont(new Font("宋体", Font.PLAIN, size));
        this.add(label);
        top = top + height + top_;
        label = new JLabel();
        label.setText("【首页位置】pdf封面对应的页数   【 目录位置】pdf目录对应的页数");
        label.setBounds(10, top, 380, height);
        label.setFont(new Font("宋体", Font.PLAIN, size));
        this.add(label);
        top = top + height + top_;
        label = new JLabel();
        label.setText("【最大页数】pdf内容最大页码 【页码偏移】pdf内容页码和页数差值");
        label.setBounds(10, top, 380, height);
        label.setFont(new Font("宋体", Font.PLAIN, size));
        this.add(label);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    class ExistAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
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
