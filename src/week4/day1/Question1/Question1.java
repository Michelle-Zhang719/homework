package week4.day1.Question1;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * 在一个磁盘的文件里保存26个英文小写字母（乱序）
 * 比如: rsztuvijxypbmnocklwaefghdq
 * 将他们读入内存中进行字典排序(abcd...)
 * 把排好顺序的字母序列再重新追加写到磁盘的该文件中。(注意要先换一行再追加)
 * 要求:
 * 用字符流和字节流两种方式来实现这个需求
 * <p>
 * 思路：读到一个数组里
 *
 * @Author MinjieZhang
 * @Date 2023-03-20 20:09
 */
public class Question1 {
    //字节流实现
    @Test
    public void byteSort() throws IOException {
        FileInputStream in = new FileInputStream("src/week4/day1/Question1/c.txt");
        //存储字符的数组
        char[] englishNum = new char[26];
        //字符数组下标
        int index = 0;
        int readData;
        while ((readData = in.read()) != -1) {
            englishNum[index] = (char) readData;
            index++;
        }
        in.close();
        //自然排序
        Arrays.sort(englishNum);
//        for (char c : englishNum) {
//            System.out.println(c);
//        }
        //排好序了，写入文件
        FileOutputStream out = new FileOutputStream("src/week4/day1/Question1/c.txt", true);
        //实现换行
        out.write(System.lineSeparator().getBytes());
        String temp = new String(englishNum);
        out.write(temp.getBytes());
        out.close();
    }
    //字符流实现

    @Test
    public void charSort() throws IOException {
        FileReader in = new FileReader("src/week4/day1/Question1/c.txt");
        //存储字符的数组
        char[] englishNum = new char[26];
        //字符数组下标
        int index = 0;
        int readData;
        while ((readData = in.read()) != -1) {
            englishNum[index] = (char) readData;
            index++;
        }
        // 关闭流
        in.close();

        //自然排序
        Arrays.sort(englishNum);
        //排好序了，写入文件
        FileWriter out = new FileWriter("src/week4/day1/Question1/c.txt", true);
        //实现换行
        out.write("\r\n");
        out.write(englishNum);
        out.flush();
        out.close();
    }
}
