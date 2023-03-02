package month1.week1.day4;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 数组基本使用练习
 * 定义一个double数组用来存放学生成绩，然后键盘录入10位同学的成绩并存入数组，求这10位同学成绩的平均值。（提示：这里可以用循环来完成十次键盘录入）
 * 定义一个String数组，输出该数组的长度，并用多种方式遍历打印数组元素（常见的方式遍历即可）
 * 注：
 * 请合理使用方法，不要胡子眉毛一把抓把代码全部写在main方法里。
 * 数组遍历的方式，比如for、增强for或者使用工具类等等。
 * 建议两个需求分开写两个类完成。
 *
 * @Author MinjieZhang
 * @Date 2023-03-02 19:37
 */
public class Question6 {
    public static void main(String[] args) {
        //1.定义一个double数组用来存放学生成绩，然后键盘录入10位同学的成绩并存入数组，求这10位同学成绩的平均值
        double[] score = new double[10];
        System.out.println("请输入10位同学的成绩：");
        Scanner sc = new Scanner(System.in);
        //键盘录入10个成绩
        for (int i = 0; i < score.length; i++) {
            score[i] = sc.nextDouble();
        }
        //求10位同学成绩的平均值
        System.out.println("10位同学成绩的平均值为：\n" + getAver(score));

        //2.定义一个String数组，输出该数组的长度，并用多种方式遍历打印数组元素
        String[] arr = {"Today's", "dinner", "is", "delicious"};
        System.out.println("此String数组的长度为" + arr.length);
        //第一种遍历,使用for循环
        System.out.println("第一种遍历,使用for循环");
        traverse(arr);
        //第二种遍历，使用增强for
        System.out.println("第二种遍历，使用增强for");
        traverse2(arr);
        //第三种遍历使用工具
        System.out.println("第三种遍历使用工具");
        System.out.println(Arrays.toString(arr));

    }

    //求10位同学成绩的平均值
    public static double getAver(double[] arr) {
        double sum = 0;
        for (double elem : arr) {
            sum += elem;
        }
        double average = sum / 10.0;
        return average;
    }

    //第一种遍历，使用for循环
    public static void traverse(String[] arr) {
        // 同时判断null和数组长度为0
        // 同时判断两个条件,需要逻辑运算符
        if (arr == null || arr.length == 0) {
            System.out.println("此数组不正常");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        // 退格解决
        System.out.println("\b\b]");
    }

    //第二种遍历，使用增强for循环
    public static void traverse2(String[] arr) {
        // 同时判断null和数组长度为0
        // 同时判断两个条件,需要逻辑运算符
        if (arr == null || arr.length == 0) {
            System.out.println("此数组不正常");
            return;
        }
        System.out.print("[");
        for (String ele : arr) {
            System.out.print(ele + ", ");
        }
        System.out.println("\b\b]");
    }
}
