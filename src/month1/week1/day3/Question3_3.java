package month1.week1.day3;

import java.util.Scanner;

/**
 * Debug模式练习
 * 尝试Debug以下代码，练习IDEA的Debug模式。具体练习时，可以对照文档一边看一边练习每个按钮的作用。
 * 该题不要求留下作业痕迹，但一定要自己操作几次。
 * 以下为练习代码
 *
 * 答：右键debug模式，不能世界run
 *
 * @Author MinjieZhang
 * @Date 2023-03-01 15:39
 */
public class Question3_3 {
    public static void main(String[] args) {
        System.out.println("hello world");
        int a =  10;
        int b  = 20;
        int c;
        c = a + b;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num > 0) {
            System.out.println("你输入的数大于0");
        } else if (num == 0) {
            System.out.println("你输入的数等于0");
        } else {
            System.out.println("你输入的数小于0");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        method();
    }
    public static void method() {
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");
    }
}
