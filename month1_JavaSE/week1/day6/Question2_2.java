package month1_JavaSE.week1.day6;

import java.util.Scanner;

/**
 * 二维数组
 * 题目2
 * 已知有3个班级（一班，二班，三班）分别有3人，2人，5人
 * 键盘录入每个班级的学生的成绩，并使用二维数组存储数据
 * 然后计算： 每个班级的平均成绩，每个班级中的最高成绩和最低成绩，并输出。
 *
 * @Author MinjieZhang
 * @Date 2023-03-04 16:25
 */
public class Question2_2 {
    public static void main(String[] args) {
        int[][] score = new int[3][];
        //用于调试
//       int[][] score = {{30, 66, 48}, {10, 20}, {10, 99, 103, 45, 67}};
        inputScore(score);
        print(score);
        getClassAver(score);
        getClassMax(score);
        getClassMin(score);
    }

    //键盘录入成绩
    public static void inputScore(int[][] score) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < score.length; i++) {
            //共输入3个班
            int num = i + 1;
            System.out.println("请输入" + num + "班的人数：");
            int people = sc.nextInt();
            System.out.println("请输入此班学生的成绩");
            score[i] = new int[people];
            for (int j = 0; j < people; j++) {
                int stuScore = sc.nextInt();
                score[i][j] = stuScore;
            }
        }
    }

    //每个班级的平均成绩
    public static void getClassAver(int[][] score) {
        for (int i = 0; i < score.length; i++) {
            //3个班级
            //班级平均分
            double averClass = 0;
            //班级总分
            double sumClass = 0;
            for (int j = 0; j < score[i].length; j++) {
                sumClass += score[i][j];
            }
            averClass = sumClass / score[i].length;
            //班号
            int classNum = i + 1;
            System.out.println(classNum + "班的平均成绩为：" + averClass);
        }

    }

    //每个班级中的最高成绩
    public static void getClassMax(int[][] score) {
        for (int i = 0; i < score.length; i++) {
            //3个班级
            //班级最高分
            int maxClass = score[i][0];
            for (int j = 0; j < score[i].length; j++) {
                if (score[i][j] > maxClass) {
                    maxClass = score[i][j];
                }
            }

            //班号
            int classNum = i + 1;
            System.out.println(classNum + "班的最高分为：" + maxClass);
        }
    }

    //每个班级中的最低成绩
    public static void getClassMin(int[][] score) {
        for (int i = 0; i < score.length; i++) {
            //3个班级
            //班级最低分
            int minClass = score[i][0];
            for (int j = 0; j < score[i].length; j++) {
                if (score[i][j] < minClass) {
                    minClass = score[i][j];
                }
            }

            //班号
            int classNum = i + 1;
            System.out.println(classNum + "班的最低分为：" + minClass);
        }

    }

    public static void print(int[][] score) {
        System.out.println("3个班的成绩为");
        for (int[] cla : score) {
            System.out.print("[");
            for (int elem : cla) {
                System.out.print(elem + " ");
            }
            System.out.println("]");
        }
    }
}
