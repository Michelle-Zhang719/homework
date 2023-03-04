package practice.stage1;

import java.util.Scanner;

/**
 * @Description 第1个月第1周第3天的作业4
 * @Author MinjieZhang
 * @Date 2023-03-01 15:48
 */
public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------王道Java学生管理系统----------");
            System.out.println();
            System.out.println("            1.学 生 列 表");
            System.out.println("            2.增 加 学 生");
            System.out.println("            3.删 除 学 生");
            System.out.println("            4.修 改 学 生");
            System.out.println("            5.查 询 学 生");
            System.out.println("            6.退 出 系 统");
            System.out.println();
            System.out.println("请选择功能(1-6):");
            int opt = sc.nextInt();
            switch (opt) {
                case 6:
                    System.out.println("确认退出吗（1/2):");
                    int shut = sc.nextInt();
                    if (shut == 1) {
                        System.out.println("感谢使用本系统！");
                        return;
                    }
            }
        }
    }
}
