package month2.week5.day4;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 假设有一个字符串"abcqweracb" 在不改变前后顺序的前提下去除重复的字符得到"abcqwer"(结合使用ArrayList)
 *
 * @Author MinjieZhang
 * @Date 2023-04-06 9:10
 */
public class Question2 {
    public static void main(String[] args) {

        ArrayList<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("q");
        s.add("w");
        s.add("e");
        s.add("r");
        s.add("a");
        s.add("c");
        s.add("b");

        Iterator<String> iterator = s.iterator();
        ArrayList<String> result = new ArrayList<>();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (result.size() == 0) {
                result.add(next);
                continue;
            }
            if (!result.contains(next)) {
                result.add(next);
            } else {
                iterator.remove();
            }
        }
        for (String value : result) {
            System.out.print(value);
        }
    }
}
