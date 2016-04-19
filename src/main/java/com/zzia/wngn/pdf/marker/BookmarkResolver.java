package com.zzia.wngn.pdf.marker;

/**
 * 生成书签类
 * 
 * @author v_wanggang
 * @date 2016年1月20日 下午1:21:38
 */
public abstract class BookmarkResolver {

    protected String destPath;
    protected String sourcePath;

    protected String targetPath;
    protected String targetName;

    protected String textPath;
    protected BookmarkRule rule;
    protected ReserverType pattern;

    public String getDestPath() {
        return destPath;
    }

    public BookmarkResolver setDestPath(String destPath) {
        this.destPath = destPath;
        return this;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public BookmarkResolver setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
        return this;
    }

    public String getTextPath() {
        return textPath;
    }

    public BookmarkResolver setTextPath(String textPath) {
        this.textPath = textPath;
        return this;
    }

    public BookmarkRule getRule() {
        return rule;
    }

    public BookmarkResolver setRule(BookmarkRule rule) {
        this.rule = rule;
        return this;
    }

    public ReserverType getPattern() {
        return pattern;
    }

    public BookmarkResolver setPattern(ReserverType pattern) {
        this.pattern = pattern;
        return this;
    }

    public String getTargetPath() {
        return targetPath;
    }

    public BookmarkResolver setTargetPath(String targetPath) {
        this.targetPath = targetPath;
        return this;
    }

    public String getTargetName() {
        return targetName;
    }

    public BookmarkResolver setTargetName(String targetName) {
        this.targetName = targetName;
        return this;
    }

    public void builderBookmark(BookmarkRule rule, ReserverType pattern) {
        this.setRule(rule);
        this.setPattern(pattern);
        verify();
        builderBookmark();

    }

    public String getFileName() {
        String path = this.sourcePath;
        path = path.replace("\\", "/");
        path = path.replace("\\\\", "/");
        path.lastIndexOf("/");
        path = path.substring(path.lastIndexOf("/") + 1);
        String[] names = path.split("\\.");
        return names[0] + "_new." + names[1];
    }

    public String getFilePath() {
        String path = this.sourcePath;
        path = path.replace("\\", "/");
        path = path.replace("\\\\", "/");
        path.lastIndexOf("/");
        return path.substring(0, path.lastIndexOf("/"));
    }

    /**
     * 生成书签
     */
    protected abstract void builderBookmark();

    /**
     * 参数验证
     */
    protected abstract void verify();

}