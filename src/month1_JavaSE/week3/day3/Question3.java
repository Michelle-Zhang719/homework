package month1_JavaSE.week3.day3;

/**
 * 给定字符串"abc001DEF",请统计字符串中大写字母字符，小写字母字符，数字字符出现的次数
 * 提示: 需要遍历获取字符串中的每一个字符串
 * 答：
 * 获取字符串对象代表字符序列中，指定位置的字符
 * char charAt(int index)
 *
 * @Author MinjieZhang
 * @Date 2023-03-15 19:38
 */
public class Question3 {
    public static void main(String[] args) {
        String str = "abc001DEF";

        System.out.println("大写字母个数为：" + getBigLetter(str));
        System.out.println("小写字母个数为：" + getSmallLetter(str));
        System.out.println("数字字符个数为：" + getNum(str));

    }

    private static int getNum(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            //遍历获取字符串中的每一个字符串
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                count++;
            }
        }
        return count;
    }

    private static int getSmallLetter(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            //遍历获取字符串中的每一个字符串
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                count++;
            }
        }
        return count;
    }

    private static int getBigLetter(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            //遍历获取字符串中的每一个字符串
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                count++;
            }
        }
        return count;
    }
}
