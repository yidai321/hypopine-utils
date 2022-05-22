package pers.lxg;

import java.io.File;

/**
 * @author lxg
 * @date 2022/5/22 9:48
 */
public class Client {

    private static String pathname = "D:\\BaiduNetdiskDownload";
    private static String A_INDENT = "│    ";
    private static String B_INDENT = "     ";
    // main 分支

    private static int targetTier = 3;
    private static String normal = "├─ ";
    private static String last = "└─ ";


    public static void main(String[] args) {
        FileNode file = new TreeFileNode(pathname);
        //  不存在，返回
        if (!file.exists()) {
            return;
        }
        System.out.println(file.getName());
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            dfs(files[i], 1, i == files.length - 1, "");
        }
    }

    public static void dfs(File file, int tier, boolean isLast, String indent) {
        if (isLast) {
            System.out.println(indent + "└─ " + file.getName());
        } else {
            System.out.println(indent + "├─ " + file.getName());
        }
        if (file.isFile() || tier == targetTier) {
            return;
        }

        tier++;
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (isLast) {
                dfs(files[i], tier, i == files.length - 1, indent + "     ");
            } else {
                dfs(files[i], tier, i == files.length - 1, indent + "│    ");
            }
        }
    }


    public static void output(File file, boolean isLast, String indent) {
        if (file.isFile()) {
            System.out.println();
        }
    }

    // 根据层级判断缩进

    /**
     * @param isLast       当前文件是否是父级目录中的最后一个
     * @param isParentLast 父级目录是否是其目录的最后一个
     * @param parentIntent 父级目录的缩进样式
     * @return 当前文件的缩进样式
     */
    //  @param depth        当前文件目录层级
    public String createIntentByDepth(boolean isLast, boolean isParentLast, String parentIntent) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < depth - 2; i++) {
//            builder.append("│    ");
//        }
        String s = parentIntent + (isParentLast ? "     " : "│    ");
//        builder.append(isParentLast ? "     " : "│    ");
        return s;
    }
}