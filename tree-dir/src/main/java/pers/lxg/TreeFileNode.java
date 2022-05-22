package pers.lxg;

import java.io.File;
import java.net.URI;

/**
 * @author lxg
 * @date 2022/5/22 13:57
 */
public class TreeFileNode extends FileNode{
    public TreeFileNode(String pathname) {
        super(pathname);
    }

    public TreeFileNode(String parent, String child) {
        super(parent, child);
    }

    public TreeFileNode(File parent, String child) {
        super(parent, child);
    }

    public TreeFileNode(URI uri) {
        super(uri);
    }
    
}