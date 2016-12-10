package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.wngn.pdf.marker.BookmarkResolver;
import com.wngn.pdf.marker.BookmarkRule;
import com.wngn.pdf.marker.BookmarkTextResolver;
import com.wngn.pdf.marker.ReserverType;

public class PanelContentText extends WangPanel {

    private static final long serialVersionUID = -8040978742445218390L;

    JTextField homeField = null;
    JTextField catalogField = null;
    JTextField maxpageField = null;
    JTextField offsetField = null;
    PanelFile sourceFileButton;
    PanelFile textFileButton;

    public PanelContentText() {
        super(Color.GRAY);
        init();
    }

    public PanelContentText(Color color) {
        super(color);
        init();
    }

    public void init() {
        this.setSize(400, 200);
        this.setLayout(null);

        int marginTop = 60;
        int marginLeft = WangFrame.FRAME_WIDTH / 4;
        int lineHeight = 20;

        sourceFileButton = PanelFile.getPdfPanelFile(marginLeft, marginTop, WangFrame.FRAME_WIDTH - marginLeft * 2, 40,
                40);

        marginTop = marginTop + lineHeight + sourceFileButton.getHeight();
        textFileButton = PanelFile.getTextPanelFile(marginLeft, marginTop, WangFrame.FRAME_WIDTH - marginLeft * 2, 40,
                40);

        marginTop = marginTop + lineHeight + textFileButton.getHeight();

        JLabel offsetLabel = WangLabel.getBigLable("页码偏移", marginLeft, marginTop);
        offsetField = WangText.getBigTextField(marginLeft + offsetLabel.getWidth() + 20, marginTop, 60);

        marginTop = marginTop + lineHeight + offsetField.getHeight();
        WangButton submitButton = WangButton.getBigActiveButon(marginLeft, marginTop, "确定");
        submitButton.addActionListener(new ButtonAction(this, "submit"));

        WangButton clearButton = WangButton.getBigActiveButon(marginLeft + submitButton.getWidth() + 220, marginTop,
                "清空");
        clearButton.addActionListener(new ButtonAction(this, "clear"));

        this.add(offsetLabel);
        this.add(offsetField);

        this.add(sourceFileButton);
        this.add(textFileButton);

        this.add(submitButton);
        this.add(clearButton);

    }

    class ButtonAction implements ActionListener {
        private String type;
        private PanelContentText panel;

        public ButtonAction(PanelContentText panel, String type) {
            super();
            this.panel = panel;
            this.type = type;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("submit".equals(type)) {
                try {
                    BookmarkResolver resolver = null;
                    BookmarkRule rule = new BookmarkRule();
                    verify();
                    String textFile = panel.textFileButton.getValue();
                    resolver = new BookmarkTextResolver();
                    resolver.setTextPath(textFile);
                    String offset = panel.offsetField.getText();
                    rule.setOffset(Integer.parseInt(offset.trim()));
                    String sourceFile = panel.sourceFileButton.getValue();
                    resolver.setSourcePath(sourceFile);
                    resolver.builderBookmark(rule, ReserverType.RESERVED_NON_OUTLINE);
                    File file = getTargetFile(sourceFile);
                    if (file != null) {
                        Runtime rt = Runtime.getRuntime();
                        rt.exec("cmd   /c   start   " + file.getPath());
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                }
            } else if ("clear".equals(type)) {
                this.panel.offsetField.setText(" ");
                this.panel.sourceFileButton.resetValue();
                this.panel.textFileButton.resetValue();
            }

        }

        private File getTargetFile(String sourceFile) {
            String path = sourceFile;
            path = path.replace("\\", "/");
            path = path.replace("\\\\", "/");
            String path_ = path.substring(0, path.lastIndexOf("/") + 1);
            String name = path.substring(path.lastIndexOf("/") + 1);
            String[] names = name.split("\\.");
            String newName = names[0] + "_new." + names[1];
            path = path_ + newName;
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                return file;
            }
            return null;
        }

        private void verify() throws Exception {
            notBlank("偏移量", panel.offsetField.getText());
            notBlank("PDF文件", panel.sourceFileButton.getValue());
            notBlank("目录文件", panel.textFileButton.getValue());
        }
    }

    private void notBlank(String name, String value) throws Exception {
        if (value == null || value.length() == 0) {
            throw new Exception(name + "不能为空！");
        }
    }

}
