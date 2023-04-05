package month1_JavaSE.week3.day6;

import java.io.*;

/**
 * 给定一个文本文件，这个文件中有随机的一些数字字符(你可以自己随便打一段数字)，统计这些数字有几个偶数，几个奇数
 * 把这个结果追加写入到该文本文件的末尾。
 * 例如：
 * a.txt文件：
 * 3241256364789629090126581212515
 * 运行程序后,该文件如下:
 * 3241256364789629090126581212515
 * 偶数个数:16个
 * 奇数个数:15个
 * 注: 举的例子中,一共有31个数,直接判断这些0-9的数的奇偶性,计算个数即可
 *
 * @Author MinjieZhang
 * @Date 2023-03-18 15:40
 */
public class Question1 {
    public static void main(String[] args) throws IOException {
        //源目录
        FileInputStream in = new FileInputStream("src\\month1_JavaSE.week3\\day6\\test\\a.txt");
        int readData = 0;
        //偶数累加器
        int evenSum = 0;
        //奇数累加器
        int oddSum = 0;

        while ((readData = in.read()) != -1) {
            //文件中还有内容

            if (readData % 2 == 0) {
                //是偶数
                evenSum += 1;
            } else {
                oddSum += 1;
            }
        }
        //到这里读取完毕
        // 在方法内部直接关闭流资源
        in.close();


        //开始写东西 true代表可追加
        FileOutputStream out = new FileOutputStream("src\\month1_JavaSE.week3\\day6\\test\\a.txt", true);
        //输入换行
        out.write("\r\n".getBytes());
        String strEven = "偶数个数:" + evenSum + "个";
        out.write(strEven.getBytes());
        out.write("\r\n".getBytes());
        String strOdd = "奇数个数:" + oddSum + "个";
        out.write(strOdd.getBytes());
        out.close();
    }
}
