package month1_JavaSE.week1.day2;

import java.util.Scanner;

/**
 * Scanner基础使用练习
 * 使用Scanner依次接收以下三种数据类型的值：
 * int类型
 * String类型
 * double类型
 * 接收三个值后，再计算：
 * 求和：int + double
 * 拼接字符串：int + double + String
 * 分别接收计算结果后，输出该计算结果。
 * 注：
 * 使用Scanner时，注意不要混用next系列和nextLine方法。（原因可以查看详细文档说明）
 * 代码直接全部写在main方法中即可。
 *
 * @Author MinjieZhang
 * @Date 2023-02-28 18:58
 */
public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个int类型的值");
        int num1 = sc.nextInt();
        //用来接住回车
        sc.nextLine();
        System.out.println("请输入一个String类型的值");
        String num2 = sc.nextLine();
        System.out.println("请输入一个double类型的值");
        double num3 = sc.nextDouble();

        //求和
        System.out.println("int类型和double类型的和为：" + (num1 + num3));

        //拼接字符串
        System.out.print("拼接字符串：int + double + String 结果为：3");
        System.out.println(Integer.toString(num1)+Double.toString(num3)+num2);
    }
}
