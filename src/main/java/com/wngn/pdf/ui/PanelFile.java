package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;

public class PanelFile extends WangPanel {

    private static final long serialVersionUID = 1L;
    WangText sourceFileField = null;
    private int leftWidth;
    private String reminder;

    public PanelFile(Color color) {
        super(color);
    }

    public PanelFile(Color color, int leftWidth) {
        super(color);
        this.leftWidth = leftWidth;
    }

    public PanelFile setReminder(String reminder) {
        this.reminder = reminder;
        return this;
    }

    public String getValue() {
        String text = this.sourceFileField.getText();
        return reminder.equals(text) ? "" : text;
    }

    public void resetValue() {
        this.sourceFileField.setText(reminder);
    }

    private void init() {
        this.setLayout(null);
        if (reminder == null) {
            reminder = "选择...";
        }
        JButton sourceFileButton = new ScaleImageButton(ResourcesUtil.getIconByName("file"));
        if (leftWidth > 0) {
            sourceFileButton.setBounds(0, 0, leftWidth, this.panelHeight);
        } else {
            sourceFileButton.setBounds(0, 0, this.panelWidth / 5, this.panelHeight);
        }
        // 文件选择框
        sourceFileField = WangText.getTextField();
        sourceFileField.setText(reminder);
        if (leftWidth > 0) {
            sourceFileField.setBounds(leftWidth, 0, this.panelWidth - leftWidth, this.panelHeight);
        } else {
            sourceFileButton.setBounds(0, 0, this.panelWidth / 5, this.panelHeight);
        }
        sourceFileField.setBorderShow(false, false, false, true);
        sourceFileField.setMouse(false);
        sourceFileButton.addActionListener(new FileAction(this));
        this.add(sourceFileButton);
        this.add(sourceFileField);
    }

    class FileAction implements ActionListener {

        private PanelFile panel;

        public FileAction(PanelFile panel) {
            super();
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            jfc.setFileFilter(new FileFilter() {
                @Override
                public String getDescription() {
                    return null;
                }

                @Override
                public boolean accept(File f) {
                    if (f.isDirectory())
                        return true;
                    return f.getName().toLowerCase().endsWith(".pdf");
                }
            });
            jfc.showDialog(new JLabel(), "选择");
            File file = jfc.getSelectedFile();
            if (file.isFile()) {
                panel.sourceFileField.setText(file.getAbsolutePath());
            }
        }
    }

    public static PanelFile getPdfPanelFile(int x, int y, int width, int height, int leftWidth) {
        PanelFile file = new PanelFile(ResourcesUtil.RGB35b558, leftWidth);
        file.setReminder("请选择PDF文件...");
        file.setWidthAndHeight(width, height);
        file.init();
        file.setBounds(x, y, width, height);
        return file;
    }

    public static PanelFile getTextPanelFile(int x, int y, int width, int height, int leftWidth) {
        PanelFile file = new PanelFile(ResourcesUtil.RGB35b558, leftWidth);
        file.setReminder("请选择目录文件...");
        file.setWidthAndHeight(width, height);
        file.init();
        file.setBounds(x, y, width, height);
        return file;
    }

}
