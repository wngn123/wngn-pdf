package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

import com.wngn.pdf.marker.BookmarkFormatResolver;
import com.wngn.pdf.marker.BookmarkResolver;

public class PanelContentFormat extends WangPanel {

    private static final long serialVersionUID = -8040978742445218390L;

    PanelFile panelFile = null;

    public PanelContentFormat(Color color) {
        super(color);
        init();
    }

    public void init() {
        this.setLayout(null);
        int marginLeft = WangFrame.FRAME_WIDTH / 4;
        int marginTop = 60;
        panelFile = PanelFile.getPdfPanelFile(marginLeft, marginTop, WangFrame.FRAME_WIDTH - marginLeft * 2, 40, 50);

        WangButton formatButton = WangButton.getActiveButon(120, 60, "格式化");
        formatButton.setMargin((WangFrame.FRAME_WIDTH - formatButton.getButtonWidth()) / 2, 180);
        formatButton.addActionListener(new ButtonAction(this));
        this.add(panelFile);
        this.add(formatButton);

    }

    class ButtonAction implements ActionListener {
        private PanelContentFormat panel;

        public ButtonAction(PanelContentFormat panel) {
            super();
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String filePath = panel.panelFile.getValue();
                if (StringUtils.isBlank(filePath)) {
                    JOptionPane.showMessageDialog(null, "没有选择文件", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                BookmarkResolver resolver = new BookmarkFormatResolver();
                resolver.setSourcePath(filePath);
                resolver.builderBookmark(null, null);
                File file = getTargetFile(filePath);
                if (file != null) {
                    Runtime rt = Runtime.getRuntime();
                    rt.exec("cmd   /c   start   " + file.getPath());
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
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

    }

}
