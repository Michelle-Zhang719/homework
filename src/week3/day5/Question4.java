package week3.day5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 键盘录入一个文件路径名(可以是相对路径,也可以是绝对路径)
 * 再键盘录入一行字符串
 * 使用字节输出流将这行字符串信息,写入到相应路径名的文件中
 * 要求:
 * 可以允许进行多次键盘录入,允许持续的将字符串信息追加到目标文件中
 * 可以约定一个"end"字符串的键盘录入,作为结束向文件写入信息的标志
 * 要求必须做异常处理,使用try-with-resource结构
 *
 * @Author MinjieZhang
 * @Date 2023-03-17 22:01
 */
public class Question4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("输入路径");
        String filesrc = sc.nextLine();


        System.out.println("输入字符串(输入end时表示结束)");
        while (true) {
            String s = sc.nextLine();
            if (s.equals("end")) {
                break;
            }
            byte[] buf = s.getBytes();
            try (FileOutputStream out = new FileOutputStream(filesrc,true)) {
                out.write(buf);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
