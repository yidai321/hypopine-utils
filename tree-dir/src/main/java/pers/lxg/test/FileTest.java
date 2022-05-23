package pers.lxg.test;

import pers.lxg.pattern.ContentPattern01;
import pers.lxg.portable.Generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lxg
 * @date 2022/5/22 14:05
 */
public class FileTest {
    public static void main(String[] args) {

        File file = new File("D:\\BaiduNetdiskDownload");
        outputTest();
    }

    public static void outputTest() {
        Generator generator = new Generator(new ContentPattern01());
        generator.setPathname("D:\\BaiduNetdiskDownload");
        generator.setContentDepth(3);
        generator.setConsumer(System.out::println);

        try {
            generator.generateInFile("D:\\exam\\treedir.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        generator.generateInConsole();
    }

    public static void out() throws IOException {
        FileWriter writer = new FileWriter("");
        writer.write("sdf");
    }
}