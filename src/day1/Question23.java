package day1;

import java.util.Scanner;

/**
 * @Description 计算 2 + 4 + 6 + … + 100 的值。
 * 计算2000年1月1日到2008年1月1日相距多少天。（注意闰年）
 * 循环输入一个不为0的数进行累加，直到输入的数字为0，结束循环并最后输出累加的结果。
 * @Author MinjieZhang
 * @Date 2023-02-27
 */
public class Question23 {
    public static void main(String[] args) {
        //计算 2 + 4 + 6 + … + 100 的值。
        int sum = 0;
        for (int i = 2; i <= 100; i = i + 2) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        System.out.println("2 + 4 + 6 + … + 100 的值为" + sum);

        //计算2000年1月1日到2008年1月1日相距多少天。（注意闰年）
        int sumDay = 0;
        for (int year = 2000; year < 2008; year = year + 1) {
            // 闰年：不是整百年，取余4为0
            if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) {
                sumDay = sumDay + 366;
            } else {
                sumDay = sumDay + 365;
            }
        }
        System.out.println("2000年1月1日到2008年1月1日相距" + sumDay);

        //循环输入一个不为0的数进行累加，直到输入的数字为0，结束循环并最后输出累加的结果。
        int sumNum = 0;
        Scanner sc = new Scanner(System.in);
        // 循环输入
        while (true) {
            System.out.print("请输入一个int数值（按0结束输入）：");
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            sumNum += num;
        }
        System.out.println("输入的数累加结果是:" + sumNum);
    }
}
