package week3.day3;

/**
 * 把字符串"lengendary"中字符 改成间隔大写小写模式，
 * 即 "LeNgEnDaRy"
 * 提示:
 * 借助StringAPI
 * toLowerCase() 把字符串全部转化为小写
 * String toUpperCase() 把字符串全部转换为大写
 * <p>
 * 思路：
 * 将str转成一个字符数组，将偶数项字符串全部转成大写，奇数项字符相小写，
 * 然后在重新插回原单词的字符数组
 *
 * @Author MinjieZhang
 * @Date 2023-03-15 20:12
 */
public class Question6 {
    public static void main(String[] args) {
        String str = "lengendary";

        //把字符串转为字符数组
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            //0 2 4...偶数项转为大写
            if (i % 2 == 0) {
                cs[i] = Character.toUpperCase(cs[i]);
                continue;
            }
            //1 3 ..转为小写
            cs[i] = Character.toLowerCase(cs[i]);
        }
        String result = new String(cs);

        System.out.println(result);
    }
}
