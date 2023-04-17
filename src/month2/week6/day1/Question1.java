package month2.week6.day1;

import java.util.Arrays;
import java.util.List;

/**
 * 1, 给定一个数字列表, 如何返回一个由每个数的平方构成的列表?
 * // [1,2,3,4,5] -> [1,4,9,16,25]
 * List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
 *
 * @Author MinjieZhang
 * @Date 2023-04-03 19:47
 */
public class Question1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        for (int i = 0; i < list.size(); i++) {
            int temp = (int) Math.pow(list.get(i), 2);
            list.set(i, temp);
        }

        System.out.println(list);
    }
}
