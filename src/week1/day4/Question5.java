package week1.day4;

import java.util.Arrays;

/**
 * 数组基本使用练习
 * 现在你去参加歌唱比赛。有10个评委打分，规则是去掉最高分和最低分，求平均分是最终成绩。请编码计算出你的最终成绩~
 * 注：
 * 请合理使用方法，不要胡子眉毛一把抓把代码全部写在main方法里。
 * 最高分和最低分可能有多个，但只需要去掉其中一个即可（也就是说平均成绩要除以8）
 * 建议给出下面的三个方法：
 * 求数组中元素最大值的方法
 * 求数组中元素最小值的方法
 * 求数组中元素平均分的方法
 *
 * @Author MinjieZhang
 * @Date 2023-03-02 19:13
 */
public class Question5 {
    public static void main(String[] args) {
        //假设十个评委的分数为
        double[] score = {8.5, 8.4, 7.6, 7.9, 9.4, 7.1, 7.1, 9.5, 9, 8};
        System.out.println("10个评委打的分数为：\n" + Arrays.toString(score));
        //找数组中最大值的下标
        int maxIndex = getMax(score);
        //找数组中最小值的下标
        int minIndex = getMin(score);
        //将数组中的最大值和最小值变为0
        score[maxIndex] = 0;
        score[minIndex] = 0;
        System.out.println("去掉最高分和最低分，平均分为：\n" + getAver(score));


    }

    //找数组中最大值的元素，并返回其下标
    public static int getMax(double[] arr) {
        // 设第一个元素是最大值，其下标为0
        int max = 0;
        //用for循环遍历数组，逐一比较
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        // 返回最大值下标
        return max;
    }

    //找数组中最小值的元素，并返回其下标
    public static int getMin(double[] arr) {
        // 设第一个元素是最小值，其下标为0
        int min = 0;
        //用for循环遍历数组，逐一比较
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        // 返回最大值下标
        return min;
    }

    //求数组中所有元素的平均数
    public static double getAver(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double average = sum / 8.0;
        return average;
    }
}
