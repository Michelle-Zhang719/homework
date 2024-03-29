package month1_JavaSE.week4.day1.Question2;

import java.io.*;

/**
 * 利用字符流去读取一个文本文件，每次读取一行，并将这行数据逆序，写入新的文本文件当中
 * 比如a.txt:
 * 我今晚要吃西瓜
 * 你今晚吃什么呢?
 * 那么输出流得到的b.txt就是:
 * 瓜西吃要晚今我
 * ?呢么什吃晚今你
 *
 * @Author MinjieZhang
 * @Date 2023-03-20 20:46
 */
public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/month1_JavaSE.week4/day1/Question2/a.txt"));

        // 循环读取
        StringBuilder sb = new StringBuilder("");
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
            sb.append(",");
        }
        // close
        in.close();
        String newStr = sb.toString();
        String[] noPrizeNameList = newStr.split(",");
//        for (String s : noPrizeNameList) {
//            System.out.println(s);
//        }
        //已经分好组了
        BufferedWriter out = new BufferedWriter(new FileWriter("src/month1_JavaSE.week4/day1/Question2/b.txt", true));
        //写两行
        for (int i = 0; i < noPrizeNameList.length; i++) {
            //字符串有几个字，就循环几次
            for (int j = noPrizeNameList[i].length() - 1; j >= 0; j--) {
                out.write(noPrizeNameList[i], j, 1);
            }
            out.write("\r\n");
            out.flush();
        }
        out.close();

    }
}
