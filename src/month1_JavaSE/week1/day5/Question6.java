package month1_JavaSE.week1.day5;

/**
 * 可变参数练习
 * 可变参数的本质是数组，完成下列需求：
 * 求不限定个数参数的最大值（要求使用可变参数，使用int类型即可）
 * 注：纯粹语法练习,可变参数直接当数组处理即可.
 *
 * @Author MinjieZhang
 * @Date 2023-03-03 19:24
 */
public class Question6 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        getMax(num1, num2, num3, num4);
    }

    public static void getMax(int... var) {
        int max = var[0];
        for (int elem : var) {
            if (elem > max) {
                max = elem;
            }
        }
        System.out.println("最大值为：" + max);
    }
}
