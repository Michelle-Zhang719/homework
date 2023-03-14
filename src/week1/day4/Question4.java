package week1.day4;

import java.util.Arrays;

/**
 * 数组基础练习——除以首元素
 * 定义一个double类型的数组，让数组中每个元素（包括首位元素）都除以首位元素，得到的结果过作为该位置上的新元素。
 * 例如数组[ 2.0 , 4.0 , 6.0 , 4.0 ] 经过方法运算得到新数组 [ 1.0 ,2.0 , 3.0 ,2.0 ]
 * 注：
 * 思考能不能直接在原先数组上完成，思考方法的返回值类型写什么。
 * 注意元素取值的变化。
 *
 * @Author MinjieZhang
 * @Date 2023-03-02 18:58
 */
public class Question4 {
    public static void main(String[] args) {
        double[] arr = {2.0, 4.0, 6.0, 4.0};
        double firEle = arr[0];
        System.out.println("原数组为：\n" + Arrays.toString(arr));
        divideFirstElement(arr, firEle);
        System.out.println("每个元素除以首位元素后的数组为:\n" + Arrays.toString(arr));

    }

    public static void divideFirstElement(double[] arr, double div) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / div;
        }
    }
}
