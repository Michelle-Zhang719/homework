package week1.day5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 利用数组元素的拷贝，实现真正意义上的在一个int数组中新增一个元素。新增元素的位置可自由决定，不要求排序，实现功能即可。
 *
 * @Author MinjieZhang
 * @Date 2023-03-03 19:51
 */
public class Question9 {
    public static void main(String[] args) {
        int[] arr = {1, 45, 6, 23, 65, 34};
        System.out.println("原数组为：" + Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入新增加的int元素:");
        int num = sc.nextInt();
        creatEle(arr, num);
    }

    public static void creatEle(int arr[], int num) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length-1] = num;
        System.out.println("元素增加后，数组为：" + Arrays.toString(newArr));
    }
}
