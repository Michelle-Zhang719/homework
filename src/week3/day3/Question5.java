package week3.day3;

/**
 * "peter piper picked a peck of pickled peppers"
 * 统计这段绕口令有多少个以p开头的单词
 * 提示:借助split(" ")方法分隔成字符串数组 , startsWith("p")判断是否是p开头
 *
 * @Author MinjieZhang
 * @Date 2023-03-15 20:03
 */
public class Question5 {
    public static void main(String[] args) {
        String str = "peter piper picked a peck of pickled peppers";
        System.out.println("以p开头的单词个数为：" + getPNum(str));
    }

    private static int getPNum(String str) {
        int count = 0;
        //借助split(" ")方法分隔成字符串数组
        String[] split = str.split(" ");

        for (String s : split) {
            //startsWith("p")判断是否是p开头
            if (s.startsWith("p")) {
                count++;
            }
        }

        return count;
    }
}
