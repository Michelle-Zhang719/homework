package week1.day2;

import java.util.Scanner;

/**
 * Scanner基础使用练习
 * 键盘输入某个学生的三门学科（数学，语文，英语）成绩，然后分别求出三科成绩的平均分，最低分，最高分，三科的总分。
 * 注：
 * 代码直接写在main()方法中即可，注意命名规范！
 * 注意录入数据的数据类型。
 * 注意命名规范。
 *
 * @Author MinjieZhang
 * @Date 2023-02-28 18:36
 */
public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数学成绩：");
        double math = sc.nextDouble();
        System.out.println("请输入语文成绩：");
        double chinese = sc.nextDouble();
        System.out.println("请输入英语成绩：");
        double english = sc.nextDouble();

        //求平均分
        double aver = 0;
        aver = (math + chinese + english) / 3.0;
        System.out.println("平均分为：" );
        System.out.println(String.format("%.2f", aver));

        //求最低分
        double temp = 0;
        if (math >= chinese) {
            temp = chinese;
        } else {
            temp = math;
        }
        System.out.print("最低分为：");
        System.out.println((temp <= english) ? temp : english);

        //求最高分
        double temp2 = 0;
        if (math >= chinese) {
            temp2 = math;
        } else {
            temp2 = chinese;
        }
        System.out.print("最高分为：");
        System.out.println((temp2 >= english) ? temp2 : english);

        //求总分
        System.out.println("三科总分为：");
        System.out.println(math + chinese + english);
    }
}
