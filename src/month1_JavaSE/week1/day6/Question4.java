package month1_JavaSE.week1.day6;

import java.util.Arrays;

/**
 * 首先准备两个数组（简单起见，用两个普通int数组即可）将这两个数组合并。
 * 所谓合并就是将两个数组中的元素合并成一个新数组。
 * 比如对于数组1[1,2,3]和数组2[2,2,2]
 * 合并的结果是新数组[1,2,3,2,2,2]
 * 注：
 * 数组合并也是很常见的操作，实际开发中有很多现成的手段去完成它。由于有些手段是超纲的，所以这里不再细表。
 * 如果后续工作中碰到了，可以再百度学习一下。目前就先考虑自己手写实现就可以了。
 *
 * @Author MinjieZhang
 * @Date 2023-03-04 16:05
 */
public class Question4 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 2, 2};

        mergeArr(arr1, arr2);
    }

    public static void mergeArr(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < newArr.length; i++) {
            if (i < arr1.length) {
                newArr[i] = arr1[i];
            } else {
                newArr[i] = arr2[i - arr1.length];
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}
