package month1_JavaSE.week1.day6;

import java.util.Arrays;

/**
 * 随意给出一个长度为10的int数组，然后升序排列它。
 * 注：
 * 如果想自己手写排序实现，可以使用最简单的冒泡排序或者选择排序。（简单的算法知识，不会就百度一下）
 * 排序对于数组而言是非常常见的操作，Java源码工具类中，早有对应的实现，比如Arrays.sort。
 * 请百度查询一下，不需要了解它具体怎么实现的（实际上它使用的是变异的双端快速排序算法），会用即可。
 *
 * @Author MinjieZhang
 * @Date 2023-03-04 15:25
 */
public class Question3 {
    public static void main(String[] args) {
        int[] arr = {10, 30, 2, 4, 67, 111, 34, 56, 78, 9};
        ascendSort(arr);
    }

    public static void ascendSort(int[] arr) {
        System.out.println("排序前数组为：" + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            //外层循环，表示趟数,每一趟找到最小的
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                //内层循坏，找到当前排序数组中，最小值元素的下标
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //将最小值元素与i的位置进行交换
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println("数组升序为：" + Arrays.toString(arr));
    }
}
