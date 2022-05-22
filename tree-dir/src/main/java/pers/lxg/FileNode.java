package pers.lxg;

import java.io.File;
import java.net.URI;

/**
 * @author lxg
 * @date 2022/5/22 13:15
 */
public abstract class FileNode extends File {
    // 缩进样式
    public String indent;
    // 是否时目录中最后一个
    public boolean isLast;

    public FileNode(String pathname) {
        super(pathname);
    }

    public FileNode(String parent, String child) {
        super(parent, child);
    }

    public FileNode(File parent, String child) {
        super(parent, child);
    }

    public FileNode(URI uri) {
        super(uri);
    }
}