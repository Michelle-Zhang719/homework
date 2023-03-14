package week1.day5;

import java.util.Arrays;

/**
 * 对于某个String类型数组，将其中的某个元素全部去掉，得到一个新数组，并统计去掉了几个元素。
 * 举例，对于String数组["abc", "123", "123", "123", "666", "777"] 将其中的元素"123"全部去掉，就得到了新数组["abc","666", "777"]，一共去掉了3个元素。
 *
 * @Author MinjieZhang
 * @Date 2023-03-03 21:40
 */
public class Question4_correct {
    public static void main(String[] args) {
        String[] oldArr = {"123", "456", "789", "123", "123", "666", "777"};
        // 获取删除元素后新数组的长度
        String target = "123";
        int delNum = getDeleteElementNum(oldArr, target);
        // 创建新数组 直接减掉重复元素的个数
        String[] newArr = new String[oldArr.length - delNum];
        deleteElement(oldArr, newArr, target);

        // 遍历查看新数组
        System.out.println(Arrays.toString(newArr));
    }

    //传入两个数组，删除old数组中的target元素，得到一个新数组
    public static void deleteElement(String[] oldArr, String[] newArr, String target) {
        // 新数组的下标
        int newIndex = 0;
        //遍历old数组
        for (int i = 0; i < oldArr.length; i++) {
            // null元素跳过,避免空指针异常
            if (oldArr[i] == null) {
                continue;
            }
            // 找到不是目标元素的元素复制进新数组
            if (!oldArr[i].equals(target)) {
                newArr[newIndex] = oldArr[i];
                //赋值后数组下标+1
                newIndex++;
            }
        }
    }

    //获取一个数组中目标数据的个数
    public static int getDeleteElementNum(String[] oldArr, String target) {
        // 计数器
        int count = 0;
        for (int i = 0; i < oldArr.length; i++) {
            // null元素跳过,避免空指针异常
            if (oldArr[i] == null) {
                continue;
            }
            if (oldArr[i].equals(target)) {
                count++;
            }
        }
        return count;
    }
}