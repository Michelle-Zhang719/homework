package month1_JavaSE.week3.day6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * (选做)递归查找指定目录中(包括子目录中)，所有的.java文件，并且，把所有这些找到的java文件，复制(是复制不是移动)到一个指定的目录下
 *
 * @Author MinjieZhang
 * @Date 2023-03-18 17:06
 */

public class Question2_correct {
    public static void main(String[] args) throws IOException {
        // 指定源目录
        File srcDir = new File("E:\\1");
        // 指定目的目录
        File desDir = new File("E:\\1\\java");
        // 查找java文件
        findFileAndCopy(srcDir, desDir);
    }

    private static void findFileAndCopy(File srcDir, File desDir) throws IOException {
        // 从源目录中找java文件
        File[] files = srcDir.listFiles();
        if (files == null) {
            System.out.println("源目录不存在或是文件!");
            return;
        }
        // 遍历源目录的所有文件/文件夹
        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".java")) {
                    // 判断是否是java源文件,进行复制操作
                    copyFile(file, desDir);
                }
            } else {
                // 不是一个文件,而是一个目录,递归查看以及复制
                findFileAndCopy(file, desDir);
            }
        }
    }

    private static void copyFile(File srcFile, File desDir) throws IOException {
        // 创建输入流对象
        FileInputStream in = new FileInputStream(srcFile);
        // 创建输出流对象
        FileOutputStream out = new FileOutputStream(desDir + "\\" + srcFile.getName());
        // 边读边写
        byte[] bytes = new byte[1024];
        int readCount;
        while ((readCount = in.read(bytes)) != -1) {
            out.write(bytes, 0, readCount);
        }
        // close
        in.close();
        out.close();
    }

}
