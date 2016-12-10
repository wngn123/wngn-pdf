package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.wngn.pdf.marker.BookmarkPageResolver;
import com.wngn.pdf.marker.BookmarkResolver;
import com.wngn.pdf.marker.BookmarkRule;
import com.wngn.pdf.marker.ReserverType;

public class PanelContentPage extends WangPanel {

    private static final long serialVersionUID = -8040978742445218390L;

    JTextField homeField = null;
    JTextField catalogField = null;
    JTextField maxpageField = null;
    JTextField offsetField = null;
    PanelFile sourceFileButton;

    public PanelContentPage() {
        super(Color.GRAY);
        init();
    }

    public PanelContentPage(Color color) {
        super(color);
        init();
    }

    public void init() {
        this.setSize(400, 200);
        this.setLayout(null);

        int marginTop = 60;
        int marginLeft = WangFrame.FRAME_WIDTH / 4;
        int lineHeight = 20;
        int offsetWidth = 20;
        int marginLeftToo = marginLeft;
        JLabel homeLabel = WangLabel.getBigLable("首页位置", marginLeft, marginTop);
        homeField = WangText.getBigTextField(marginLeft + homeLabel.getWidth() + offsetWidth, marginTop, 60);
        marginLeftToo = marginLeft + homeLabel.getWidth() + homeField.getWidth() + offsetWidth * 2;

        JLabel catalogLabel = WangLabel.getBigLable("目录位置", marginLeftToo, marginTop);
        catalogField = WangText.getBigTextField(marginLeftToo + catalogLabel.getWidth() + offsetWidth, marginTop, 60);

        marginTop = marginTop + catalogLabel.getHeight() + lineHeight;
        JLabel maxpageLabel = WangLabel.getBigLable("最大页码", marginLeft, marginTop);
        maxpageField = WangText.getBigTextField(marginLeft + maxpageLabel.getWidth() + offsetWidth, marginTop, 60);

        JLabel offsetLabel = WangLabel.getBigLable("页码偏移", marginLeftToo, marginTop);
        offsetField = WangText.getBigTextField(marginLeftToo + offsetLabel.getWidth() + offsetWidth, marginTop, 60);

        marginTop = marginTop + maxpageLabel.getHeight() + lineHeight;
        sourceFileButton = PanelFile.getPdfPanelFile(marginLeft, marginTop, WangFrame.FRAME_WIDTH - marginLeft * 2, 40,
                40);
        marginTop = marginTop + sourceFileButton.getHeight() + lineHeight;

        WangButton submitButton = WangButton.getBigActiveButon(marginLeft, marginTop, "确定");
        submitButton.addActionListener(new ButtonAction(this, "submit"));

        WangButton clearButton = WangButton.getBigActiveButon(marginLeft + submitButton.getWidth() + 220, marginTop,
                "清空");
        clearButton.addActionListener(new ButtonAction(this, "clear"));

        this.add(homeLabel);
        this.add(homeField);
        this.add(catalogLabel);
        this.add(catalogField);
        this.add(maxpageLabel);
        this.add(maxpageField);
        this.add(offsetLabel);
        this.add(offsetField);

        this.add(sourceFileButton);

        this.add(submitButton);
        this.add(clearButton);

    }

}

class ButtonAction implements ActionListener {
    private String type;
    private PanelContentPage panel;

    public ButtonAction(PanelContentPage panel, String type) {
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
                resolver = new BookmarkPageResolver();
                String home = panel.homeField.getText().trim();
                String catalog = panel.catalogField.getText().trim();
                String maxpage = panel.maxpageField.getText().trim();
                rule.setHome(Integer.parseInt(home));
                rule.setCatalog(Integer.parseInt(catalog));
                rule.setMaxpage(Integer.parseInt(maxpage));

                String offset = panel.offsetField.getText().trim();
                rule.setOffset(Integer.parseInt(offset));
                String sourceFile = panel.sourceFileButton.getValue();
                resolver.setSourcePath(sourceFile);
                resolver.builderBookmark(rule, ReserverType.RESERVED_NON_OUTLINE);
                File file = getTargetFile(sourceFile);
                if (file != null) {
                    Runtime rt = Runtime.getRuntime();
                    rt.exec("cmd   /c   start   " + file.getPath());
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
        } else if ("clear".equals(type)) {
            panel.homeField.setText(" ");
            panel.catalogField.setText(" ");
            panel.maxpageField.setText(" ");
            panel.offsetField.setText(" ");
            panel.sourceFileButton.resetValue();
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
        notBlank("首页页码", panel.homeField.getText());
        notBlank("目录页码", panel.catalogField.getText());
        notBlank("最大页码", panel.maxpageField.getText());
        notBlank("PDF文件", panel.sourceFileButton.getValue());

    }

    private void notBlank(String name, String value) throws Exception {
        if (value == null || value.length() == 0) {
            throw new Exception(name + "不能为空！");
        }
    }

}
