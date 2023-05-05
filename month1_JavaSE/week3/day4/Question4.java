package month1_JavaSE.week3.day4;

/**
 * 判断一个字符串是否是对称字符串,例如"abc"不是对称字符串，"aba"、"abba"、"aaa"、"mnanm"是对称字符串
 * 提示: 判断一个字符串是否是对称的字符串，我只需要把 第一个和最后一个比较 第二个和倒数第二个比较 ... 可以借助StringBuffer
 *
 * @Author MinjieZhang
 * @Date 2023-03-16 20:43
 */
public class Question4 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("manam");
        judgeString(sb);
    }

    private static void judgeString(StringBuilder sb) {
        // 将此字符序列用其反转形式取代，返回对象本身
        StringBuilder newSB = sb.reverse();
        if (newSB.equals(sb)){
            System.out.println(sb+"是对称字符串");
        }else{
            System.out.println(sb+"不是对称字符串");
        }
    }
}
