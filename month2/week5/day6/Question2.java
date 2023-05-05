package month2.week5.day6;

import java.util.ArrayList;
import java.util.List;

/**
 * "aababcabcdabcde",获取字符串中每一个字母出现的次数要求结果:a(5)b(4)c(3)d(2)e(1)
 *
 * @Author MinjieZhang
 * @Date 2023-04-01 16:55
 */
public class Question2 {
    public static void main(String[] args) {
        String s = "aababcabcdabcde";
        char[] chars = s.toCharArray();
        //保存出现过的字母
        List<Character> existC = new ArrayList<>();
        List<Exist> e = new ArrayList<>();


        //保存字符串中有几种字母
        for (int i = 1; i < chars.length; i++) {
            if (!existC.contains(chars[i])) {
                //第一次见到某个字母
                existC.add(chars[i]);
                e.add(new Exist(1, chars[i]));
                continue;
            }
            //不是第一次见到
            for (Exist exist : e) {
                if (exist.value == chars[i]) {
                    exist.count++;
                }
            }
        }
//        System.out.println(existC);
        printResult(e);


    }

    private static void printResult(List<Exist> e) {
        for (Exist exist : e) {
            System.out.println(exist.value + "(" + exist.count + ")");
        }
    }
}

class Exist {
    //此字母出现的次数
    int count;
    // 字母本身
    char value;

    public Exist(int count, char value) {
        this.count = count;
        this.value = value;
    }
}