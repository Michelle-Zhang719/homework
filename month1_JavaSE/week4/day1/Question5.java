package month1_JavaSE.week4.day1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 从磁盘上读取一个文本文件（推荐找一个Java源代码文件），
 * 分别统计出文件中英文字母、空格、数字字符的个数。(注意文本文件中的数字指的是数字字符！！！)
 *
 * @Author MinjieZhang
 * @Date 2023-03-20 22:45
 */

public class Question5 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/month1_JavaSE.week4/day1/Question5.java");
        func(file);
    }

    private static void func(File file) throws IOException {
        //字符输入流对象
        Reader reader = new FileReader(file);

        int readCode;
        char[] cs = new char[1024];
        int countLetter = 0;
        int countDigit = 0;
        int countSpace = 0;

        while ((readCode = reader.read(cs)) != -1) {
            for (int i = 0; i < readCode; i++) {
                if ((cs[i] > 'a' && cs[i] < 'z') || (cs[i] > 'A' && cs[i] < 'Z')) {
                    countLetter++;
                } else if (cs[i] > '0' && cs[i] < '9') {
                    countDigit++;
                } else if (cs[i] == ' ') {
                    countSpace++;
                }
            }
        }

        System.out.println("字母出现的次数：" + countLetter);
        System.out.println("数字字符出现的次数：" + countDigit);
        System.out.println("空格出现的次数：" + countSpace);

    }
}