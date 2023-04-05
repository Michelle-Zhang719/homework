package month1_JavaSE.week4.day1.Question3;

import java.io.*;


/**
 * 准备一个文本文件，其中包含英文 ,数字, 中文字符。
 * 设计一个方法
 * public static void encodeFile(File encodingFile, File encodedFile);
 * 在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
 * 加密算法：
 * 1.数字： 如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4 如果是9的数字，变成0
 * 2.字母字符： 如果是非z字符，向右移动一个，比如d变成e, G变成H 如果是z，z->a, Z-A。
 * 注：字母字符加密的过程不能改变大小写
 * 3.非数字和字母的字符则保持不变即可，比如汉字和标点符号等都只需要保持不变即可
 *
 * @Author MinjieZhang
 * @Date 2023-03-20 21:18
 */
public class Question3 {
    public static void main(String[] args) throws IOException {
        //使用字符流比字节流要好
        //源文件
        File in = new File("src/month1_JavaSE.week4/day1/Question3/for3.txt");
        //目标文件
        File out = new File("src/month1_JavaSE.week4/day1/Question3/encoded.txt");
        encodeFile(in, out);

    }

    public static void encodeFile(File encodingFile, File encodedFile) throws IOException {
        char[] c = getCharacter(encodingFile);
        //加密过程
        //乱七八糟累加器
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\r' || c[i] == '\n' || c[i] == '\u0000') {
                count++;
                continue;
            }
            //如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4 如果是9的数字，变成0
            if (c[i] <= '8') {
                c[i] += 1;
                continue;
            }
            if (c[i] == '9') {
                c[i] = '0';
                continue;
            }
            //如果是非z字符，向右移动一个，比如d变成e, G变成H 如果是z，z->a, Z-A。
            if (c[i] == 'z') {
                c[i] = 'a';
                continue;
            }
            if (c[i] == 'Z') {
                c[i] = 'A';
                continue;
            }
            if (c[i] >= 'a' && c[i] <= 'y') {
                c[i] += 1;
                continue;
            }
            if (c[i] >= 'A' && c[i] <= 'Y') {
                c[i] += 1;
                continue;
            }
        }
        char[] newC = new char[c.length - count];
        int index = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\r' || c[i] == '\n' || c[i] == '\u0000') {
                count++;
                continue;
            }
            newC[index]=c[i];
            index++;
        }

        //写入文件
        FileWriter out = new FileWriter(encodedFile, true);
        out.write(newC);
        out.close();


    }

    /**
     * 得到源文件内的所有字符，并返回一个字符数组
     *
     * @param encodingFile 源文件路径
     * @return char[]
     * @author MinjieZhang
     * @date 2023/03/20 22:16
     */
    private static char[] getCharacter(File encodingFile) throws IOException {
        //字符输入流对象
        FileReader in = new FileReader(encodingFile);
        //存储字符的可变字符串
//        StringBuilder sb = new StringBuilder("");
        char[] c = new char[(int) encodingFile.length()];
        //字符数组下标
        int index = 0;
        int readData;
        while ((readData = in.read()) != -1) {

            c[index] = (char) readData;
            index++;
        }
        // 关闭流
        in.close();
        return c;
    }
}
