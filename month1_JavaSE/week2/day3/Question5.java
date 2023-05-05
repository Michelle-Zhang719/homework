package month1_JavaSE.week2.day3;

import java.util.Random;
import java.util.Scanner;

/**
 * 猜数小游戏
 * 百度和各种搜索引擎就是生产力，尝试自己解决以下问题：
 * 先生成一个随机数（1~100之间的整数），再键盘输入猜测的数 如果猜的数大了或者小了，给出提示，继续猜，直到猜中为止。
 * 注：Java如何生成随机数，自己百度查一下非常简单。这点学习能力还是需要具备的。
 *
 * @Author MinjieZhang
 * @Date 2023-03-08 15:05
 */
public class Question5 {
    public static void main(String[] args) {
        Random r = new Random();
        int target = r.nextInt(100);
        Scanner sc = new Scanner(System.in);
        int num;

        while (true) {
            System.out.println("请输入猜测的数字");
            num = sc.nextInt();

            if (num < target) {
                System.out.println("小了，请往大猜");
            }
            if (num > target) {
                System.out.println("大了，请往小猜");
            }
            if (num == target) {
                System.out.println("猜对了");
                break;
            }
        }
    }
}
