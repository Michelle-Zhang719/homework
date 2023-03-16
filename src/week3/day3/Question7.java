package week3.day3;

/**
 * 对于字符串”woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun”
 * 统计其中"java"字符串出现的次数。
 * 提示：java出现了5次
 * 提示：可以考虑使用indexOf方法，仅考虑本题举出的字符串，无需复杂考虑
 * <p>
 * 思路：
 * 从头开始查找，如果找到了，要获取找到处的索引
 * 找到一次，使次数加1
 * 让下一次开始检索处为 上一次找到的索引 + 需要查找的字符长度
 *
 * @Author MinjieZhang
 * @Date 2023-03-15 20:27
 */
public class Question7 {
    public static void main(String[] args) {
        String target = "java";
        String str = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";

        System.out.println("java出现的次数为：" + getNum(str, target));

    }

    private static int getNum(String str, String target) {
        int count = 0;
        //开始遍历字符串的位置
        int start = 0;
        int targetLen = target.length();
        while (true) {
            //找到目标字符串
            if (str.indexOf(target, start) != -1) {
                count++;
                //获取目标字符串所在位置索引（目标字符串第一个字符的位置）
                start = str.indexOf(target, start);

                //下次开始遍历的位置
                start = start + targetLen;
            } else {
                break;
            }
        }
        return count;
    }
}
