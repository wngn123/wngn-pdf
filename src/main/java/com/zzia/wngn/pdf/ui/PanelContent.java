package com.zzia.wngn.pdf.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import com.zzia.wngn.pdf.marker.BookmarkFormatResolver;
import com.zzia.wngn.pdf.marker.BookmarkPageResolver;
import com.zzia.wngn.pdf.marker.BookmarkResolver;
import com.zzia.wngn.pdf.marker.BookmarkRule;
import com.zzia.wngn.pdf.marker.BookmarkTextResolver;
import com.zzia.wngn.pdf.marker.ReserverType;

@SuppressWarnings("serial")
public class PanelContent extends WangPanel {

    JTextField homeField = null;
    JTextField catalogField = null;
    JTextField maxpageField = null;
    JTextField offsetField = null;
    WangText sourceFileField = null;
    WangText textFileField = null;
    JRadioButton pageRadioButton = null;
    JRadioButton textRadioButton = null;
    JButton textFileButton = null;

    public PanelContent() {
        super(Color.GRAY);
        init();
    }

    public void init() {
        this.setSize(400, 200);
        this.setLayout(null);
        JLabel homeLabel = WangLabel.getLable("首页位置");
        JLabel catalogLabel = WangLabel.getLable("目录位置");
        JLabel maxpageLabel = WangLabel.getLable("最大页码");
        JLabel offsetLabel = WangLabel.getLable("页码偏移");
        homeField = WangText.getTextField();
        catalogField = WangText.getTextField();
        maxpageField = WangText.getTextField();
        offsetField = WangText.getTextField();
        // 定位组件的位置与大小
        homeLabel.setBounds(270, 10, 60, 20);
        catalogLabel.setBounds(270, 40, 60, 20);
        maxpageLabel.setBounds(270, 70, 60, 20);
        offsetLabel.setBounds(270, 100, 60, 20);

        homeField.setBounds(340, 10, 40, 20);
        catalogField.setBounds(340, 40, 40, 20);
        maxpageField.setBounds(340, 70, 40, 20);
        offsetField.setBounds(340, 100, 40, 20);

        JButton sourceFileButton = WangButton.getActiveButon("");
        sourceFileButton.setIcon(ResourcesUtil.getWngnFileIcon());
        sourceFileButton.setBounds(30, 20, 30, 20);
        sourceFileField = WangText.getTextField();
        sourceFileField.setText("选择PDF文件......");
        sourceFileField.setBounds(60, 20, 180, 20);
        sourceFileField.setBorderShow(false, false, false, true);
        sourceFileField.setMouse(false);
        textFileButton = WangButton.getActiveButon("");
        textFileButton.setIcon(ResourcesUtil.getWngnFileIcon());
        textFileButton.setBounds(30, 80, 30, 20);
        textFileField = WangText.getTextField();
        textFileField.setText("选择目录文件......");
        textFileField.setBorderShow(false, false, false, true);
        textFileField.setBounds(60, 80, 180, 20);
        textFileField.setMouse(false);
        sourceFileButton.addActionListener(new SourceFileButton(this, "src"));
        textFileButton.addActionListener(new SourceFileButton(this, "txt"));

        pageRadioButton = new JRadioButton("页码生成书签");// 创建单选按钮
        pageRadioButton.setBackground(Color.GRAY);
        pageRadioButton.setFont(new Font("宋体", Font.PLAIN, 12));
        pageRadioButton.setBounds(30, 50, 105, 20);
        pageRadioButton.addActionListener(new SourceFileButton(this, "pageRadio"));
        textRadioButton = new JRadioButton("文本生成书签");// 创建单选按钮
        textRadioButton.setBackground(Color.GRAY);
        textRadioButton.setBounds(135, 50, 105, 20);
        textRadioButton.setFont(new Font("宋体", Font.PLAIN, 12));
        textRadioButton.addActionListener(new SourceFileButton(this, "textRadio"));
        ButtonGroup group = new ButtonGroup();// 创建单选按钮组
        // 将radioButton1增加到单选按钮组中
        group.add(pageRadioButton);
        group.add(textRadioButton);

        WangButton submitButton = WangButton.getActiveButon("确定");
        submitButton.setMargin(30, 110);
        submitButton.addActionListener(new SourceFileButton(this, "submit"));

        WangButton clearButton = WangButton.getActiveButon("清空");
        clearButton.setMargin(85, 110);
        clearButton.addActionListener(new SourceFileButton(this, "clear"));

        WangButton cancelButton = WangButton.getActiveButon("取消");
        cancelButton.setMargin(140, 110);
        cancelButton.addActionListener(new SourceFileButton(this, "cancel"));

        WangButton formatButton = WangButton.getActiveButon("格式化");
        formatButton.setMargin(195, 110);
        formatButton.addActionListener(new SourceFileButton(this, "format"));

        this.add(homeLabel);
        this.add(homeField);
        this.add(catalogLabel);
        this.add(catalogField);
        this.add(maxpageLabel);
        this.add(maxpageField);
        this.add(offsetLabel);
        this.add(offsetField);

        this.add(sourceFileButton);
        this.add(sourceFileField);
        this.add(textFileButton);
        this.add(textFileField);

        this.add(pageRadioButton);
        this.add(textRadioButton);

        this.add(submitButton);
        this.add(clearButton);
        this.add(cancelButton);
        this.add(formatButton);

    }

    class SourceFileButton implements ActionListener {
        private String type;
        private PanelContent panel;

        public SourceFileButton(PanelContent panel, String type) {
            super();
            this.panel = panel;
            this.type = type;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("src".equals(type)) {
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
                if (file.isDirectory()) {
                    System.out.println("文件夹:" + file.getAbsolutePath());
                } else if (file.isFile()) {
                    System.out.println("文件:" + file.getAbsolutePath());
                    System.out.println(jfc.getSelectedFile().getName());
                    panel.sourceFileField.setText(file.getAbsolutePath());
                }
            } else if ("txt".equals(type)) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                jfc.showDialog(new JLabel(), "选择");
                File file = jfc.getSelectedFile();
                if (file.isDirectory()) {
                    System.out.println("文件夹:" + file.getAbsolutePath());
                } else if (file.isFile()) {
                    System.out.println("文件:" + file.getAbsolutePath());
                    System.out.println(jfc.getSelectedFile().getName());
                    panel.textFileField.setText(file.getAbsolutePath());
                }
            } else if ("submit".equals(type)) {
                try {
                    BookmarkResolver resolver = null;
                    BookmarkRule rule = new BookmarkRule();
                    if (panel.pageRadioButton.isSelected()) {
                        verify(0);
                        resolver = new BookmarkPageResolver();
                        String home = panel.homeField.getText();
                        String catalog = panel.catalogField.getText();
                        String maxpage = panel.maxpageField.getText();
                        rule.setHome(Integer.parseInt(home));
                        rule.setCatalog(Integer.parseInt(catalog));
                        rule.setMaxpage(Integer.parseInt(maxpage));

                    } else if (panel.textRadioButton.isSelected()) {
                        verify(1);
                        String textFile = panel.textFileField.getText();
                        resolver = new BookmarkTextResolver();
                        resolver.setTextPath(textFile);
                    } else {
                        throw new RuntimeException("必须选择生成方式");
                    }
                    String offset = panel.offsetField.getText();
                    rule.setOffset(Integer.parseInt(offset));
                    String sourceFile = panel.sourceFileField.getText();
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
                panel.homeField.setText("");
                panel.catalogField.setText("");
                panel.maxpageField.setText("");
                panel.offsetField.setText("");
                panel.sourceFileField.setText("选择PDF文件......");
                panel.textFileField.setText("选择目录文件......");
                panel.pageRadioButton.setSelected(false);
                panel.textRadioButton.setSelected(false);
            } else if ("pageRadio".equals(type)) {
                panel.textFileField.setVisible(false);
                panel.textFileButton.setVisible(false);
            } else if ("textRadio".equals(type)) {
                panel.textFileField.setVisible(true);
                panel.textFileButton.setVisible(true);
            } else if ("format".equals(type)) {
                try {
                    String sourceFile = panel.sourceFileField.getText();
                    BookmarkResolver resolver = new BookmarkFormatResolver();
                    resolver.setSourcePath(sourceFile);
                    resolver.builderBookmark(null, null);
                    File file = getTargetFile(sourceFile);
                    if (file != null) {
                        Runtime rt = Runtime.getRuntime();
                        rt.exec("cmd   /c   start   " + file.getPath());
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                }
            } else if ("cancel".equals(type)) {
                System.exit(0);
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

        private void verify(int type) {
            notBlank("偏移量", panel.offsetField.getText());
            notBlank("PDF文件", panel.sourceFileField.getText());
            if (panel.sourceFileField.getText().equals("选择PDF文件......")) {
                throw new RuntimeException("PDF文件" + "不能为空！");
            }
            if (type == 0) {
                notBlank("首页页码", panel.homeField.getText());
                notBlank("目录页码", panel.catalogField.getText());
                notBlank("最大页码", panel.maxpageField.getText());
            } else {
                notBlank("目录文件", panel.textFileField.getText());
                if (panel.textFileField.getText().equals("选择目录文件......")) {
                    throw new RuntimeException("目录文件" + "不能为空！");
                }
            }
        }

        private void notBlank(String name, String value) {
            if (value == null || value.length() == 0) {
                throw new RuntimeException(name + "不能为空！");
            }
        }

    }

}
