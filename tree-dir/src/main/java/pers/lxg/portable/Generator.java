package pers.lxg.portable;

import pers.lxg.patten.ContentPattern01;

import java.io.*;
import java.util.function.Consumer;

/**
 * @author lxg
 * @date 2022/5/22 16:04
 */
public class Generator {
    public String pathname;
    public String commonIndent;
    public String rearIndent;
    public String commonTier;
    public String rearTier;
    public int contentDepth;
    public FileFilter filter;
    public Consumer<String> consumer;

    /**
     * 在控制台输出
     */
    public void generateInConsole() {
        this.generate(System.out::println);
    }

    /**
     *
     * @param filename 输出目标文件路径
     * @throws IOException
     */
    public void generateInFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        this.setConsumer((str) -> {
            try {
                bufferedWriter.write(str + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        generate(this.consumer);
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }

    /**
     *
     * @param file 当前文件
     * @param actualIndent 缩进
     * @param isLast  是否是目录中最后一个
     * @param depth  当前文件的目录层级
     * @param consumer 函数式接口 自定义输出
     */
    private void dfs(File file, String actualIndent, boolean isLast, int depth, Consumer<String> consumer) {
        if (isLast) {
            consumer.accept(actualIndent + rearTier + file.getName());
        } else {
            consumer.accept(actualIndent + commonTier + file.getName());
        }

        if (file.isFile() || depth == contentDepth) {
            return;
        }

        depth++;
        File[] files = file.listFiles(filter);
        for (int i = 0; i < files.length; i++) {
            if (isLast) {
                dfs(files[i], actualIndent + rearIndent, i == files.length - 1, depth, consumer);
            } else {
                dfs(files[i], actualIndent + commonIndent, i == files.length - 1, depth, consumer);
            }
        }
    }

    /**
     *  通用方法
     * @param consumer 函数式接口
     */
    private void generate(Consumer<String> consumer) {
        File file = new File(pathname);
        if (!file.exists()) {
            throw new RuntimeException("文件或目录不存在");
        }
        consumer.accept(file.getName());
        File[] files = file.listFiles(filter);
        for (int i = 0; i < files.length; i++) {
            dfs(files[i], "", i == files.length - 1, 1, consumer);
        }
    }

    public Generator(String pathname, String commonIndent, String rearIndent, String commonTier, String rearTier, int contentDepth) {
        this.pathname = pathname;
        this.commonIndent = commonIndent;
        this.rearIndent = rearIndent;
        this.commonTier = commonTier;
        this.rearTier = rearTier;
        this.contentDepth = contentDepth;
    }

    public Generator(ContentPattern01 pattern) {
        this.commonIndent = pattern.commonIndent;
        this.rearIndent = pattern.rearIndent;
        this.commonTier = pattern.commonTier;
        this.rearTier = pattern.rearTier;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public void setContentDepth(int contentDepth) {
        this.contentDepth = contentDepth;
    }

    public void setConsumer(Consumer<String> consumer) {
        this.consumer = consumer;
    }
}