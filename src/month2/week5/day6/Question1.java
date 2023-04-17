package month2.week5.day6;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串s和t, 它们只包含小写字母。字符串t是由s中的字母随机打乱之后，在随机的一个位置添加一个字母生成的。请找出那个添加的字母。
 * 比如：
 * s = "abcd"
 * t = "baedc"
 * 输出：e
 *
 * @Author MinjieZhang
 * @Date 2023-04-01 14:44
 */
public class Question1 {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");

        List<String> t = new ArrayList<>();
        t.add("b");
        t.add("a");
        t.add("e");
        t.add("d");
        t.add("c");

        String result = findDifference(s, t);
        System.out.println(result);

    }

    private static String findDifference(List<String> s, List<String> t) {
        for (String elem : t) {
            //用t，在s中寻找
            if (!s.contains(elem)) {
                //
                return elem;
            }

        }
        return null;
    }
}
