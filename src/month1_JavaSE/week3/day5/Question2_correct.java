package month1_JavaSE.week3.day5;

import java.io.File;

/**
 * 改正我未实现的lambda表达式
 * @Author MinjieZhang
 * @Date 2023-03-17 22:28
 */

public class Question2_correct {
    public static void main(String[] args) {
        File f = new File("src\\month1_JavaSE.week3\\day5\\test");
        // 条件1
        File[] files = f.listFiles(Question2_correct::condition2);

        // 条件2
        f.listFiles(file -> file.isFile() && file.getName().endsWith(".txt"));

        // 条件3
        f.listFiles(file -> file.isFile() && file.getName().startsWith("a"));

    }

    public static boolean condition1(File file) {
        return file.isDirectory() && file.getName().contains("a");
    }

    public static boolean condition2(File file) {
        return file.isFile() && file.getName().endsWith(".txt");
    }

    public static boolean condition3(File file) {
        return file.isFile() && file.getName().startsWith("a");
    }
}