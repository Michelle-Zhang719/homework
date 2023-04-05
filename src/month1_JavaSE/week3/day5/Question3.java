package month1_JavaSE.week3.day5;

import java.io.*;
import java.util.Scanner;


/**
 * 键盘录入一个文件路径名(可以是相对路径,也可以是绝对路径)
 * 再键盘录入一行字符串
 * 使用字节输出流将这行字符串信息,写入到相应路径名的文件中
 * (一次键盘录入,写入一次即可)
 * 要求必须做异常catch处理,不能直接throws
 *
 * @Author MinjieZhang
 * @Date 2023-03-17 21:46
 */
public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入路径");
        String filesrc = sc.nextLine();
        System.out.println("输入字符串");
        String s = sc.nextLine();
        byte[] buf = s.getBytes();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filesrc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            out.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // 判null处理
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
