package week3.day4;

import java.util.Scanner;

/**
 * Scanner进行键盘录入时，非常容易产生异常，那么就有必要进行处理
 * 我们在进行键盘录入字符串操作时，有时需要把一个字符串转换成int类型。
 * 但如果输入的字符串并不是一个数字时，显然是不能转换成功的，而是会抛出一个异常。
 * 要求： 处理该异常，让程序不会报错终止，而是让用户重新输入，直到输入正确的数字为止
 *
 * @Author MinjieZhang
 * @Date 2023-03-16 21:53
 */
public class Question7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        int a = 0;
        System.out.println("请输入一个数字字符串：");
        while (true) {
            s = sc.nextLine();

            try {
                a = Integer.parseInt(s);
                break;
            } catch (Exception e) {
                System.out.println("输入的不是数字字符串，请重新输入");
            }

        }
        System.out.println("成功转为int类型：" + a);
    }
}

