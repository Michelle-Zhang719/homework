package week1.day5;

import java.util.Arrays;

/**
 * 数组综合练习——真正删除元素
 * 对于某个String类型数组，将其中的某个元素全部去掉，得到一个新数组，并统计去掉了几个元素。
 * 举例，对于String数组["abc", "123", "123", "123", "666", "777"] 将其中的元素"123"全部去掉，就得到了新数组["abc","666", "777"]，一共去掉了3个元素。
 * 注：
 * 这里说的去掉，不是指用0/null等默认值替代原先的元素，而是指真正的删除掉。
 * 思考：同一个数组能不能实现这个功能？如果不能，应该怎么完成呢？
 * String如何判断内容相同？
 * <p>
 * 答：
 * 不能，数组一旦被定义，其长度不可更改
 * 使用equals方法
 *
 * @Author MinjieZhang
 * @Date 2023-03-03 20:32
 */
public class Question4 {
    public static void main(String[] args) {
        String[] str = {"abc", "123", "123", "123", "666", "777"};
        //被去掉的数组
        String ele = "123";
        /*
        思路：
        遍历string数组，每找到目标元素，就new一个新数组，直至遍历结束
         */
        delete(str, ele);

    }

    public static void delete(String[] str, String target) {

        //统计去掉的相同的元素的个数
        int count = 0;
        //为新数组元素下标
        String[] newStr = new String[str.length - 1];
        int newIndex = 0;
        for (int i = 0; i < str.length; i++) {
            if (target.equals(str[i]) == false) {
                //在数组中没有找到目标元素
                newStr[newIndex] = str[i];
                count++;
                newIndex++;
            }
        }
        System.out.println("删除之前数组为 " + Arrays.toString(str));
        System.out.println("删除”123“元素后，数组为 " + Arrays.toString(newStr));
    }
}
