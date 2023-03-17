package week3.day4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 制作一个工具类，算一下你来到这个世界多少天?(参考文档中的Date类)
 * 思路：将输入的日期字符串转换为时间data对象，计算出生时间和当前时间的毫秒差，在转换为天数
 *
 * @Author MinjieZhang
 * @Date 2023-03-16 21:32
 */
public class Question5 {
    public static void main(String[] args) throws ParseException {
        System.out.println("来到这个世界的天数为:" + TimeUtils.calcBornDaysNum());
    }
}

//工具类
class TimeUtils {
    private static final Scanner sc = new Scanner(System.in);

    private TimeUtils() {
    }

    public static int calcBornDaysNum() throws ParseException {
        System.out.println("请输入您的出生日期，格式yyyy-MM-dd: ");
        String birthday = sc.nextLine();
        //实现Date对象和日期字符串的相互转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //将日期表示的字符串转换成对应的Date对象
        Date birthTime = sdf.parse(birthday);
        //获取当前的日期的毫秒数
        Date currentTime = new Date();
        //获取当前Date对象的时间戳的毫秒值：
        long currentSeconds = currentTime.getTime();
        //获取出生当天Date对象的时间戳的毫秒值：
        long birthSeconds = birthTime.getTime();
        //计算毫秒值之差
        long seconds = currentSeconds - birthSeconds;
        if (seconds < 0) {
            return -1;
        } else {
            return ((int) (seconds / 1000 / 3600 / 24));
        }
    }
}