package week3.day5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Description 改正我的catch处理 没做好的问题
 * @Author MinjieZhang
 * @Date 2023-03-17 22:32
 */

public class Question3_correct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input file name
        System.out.println("请输入文件路径名:");
        String fileName = scanner.nextLine();
        // input file Content
        System.out.println("请输入文件内容:");
        String fileContent = scanner.nextLine();
        // save content to file
        saveContentToFile(fileName, fileContent);
    }

    public static void saveContentToFile(String fileName, String fileContent) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            // write
            out.write(fileContent.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}