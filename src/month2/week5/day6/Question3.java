package month2.week5.day6;

import java.util.*;

/**
 * 已知HashMap存储了一批数据 HashMap<String, Integer>;
 * 删除这批数据key-value中value为7或者8或者9的数据
 *
 * @Author MinjieZhang
 * @Date 2023-04-01 20:33
 */
public class Question3 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("zs", 1);
        hashMap.put("ls", 5);
        hashMap.put("wu", 6);
        hashMap.put("zl", 7);
        hashMap.put("cf", 8);
        hashMap.put("aa", 9);
        hashMap.put("bb", 10);
        hashMap.put("cc", 11);
        hashMap.put("dd", 11);
        hashMap.put("ee", 7);

        Iterator<Map.Entry<String, Integer>>
                it = hashMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> elem = it.next();
            if (elem.getValue() == 7 || elem.getValue() == 8 || elem.getValue() == 9) {
                it.remove();
            }
        }
        System.out.println(hashMap);

    }
}
