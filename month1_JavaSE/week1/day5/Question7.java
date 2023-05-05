package month1_JavaSE.week1.day5;

/**
 * 练习使用递归
 * 递归在实际开发中用途并不广泛，但我们仍有必要学习它的基本使用。
 * 这道题目如果想不明白，那就百度一下吧。
 * 使用递归，把十进制正整数（N>=0）转换成二进制数
 *
 * @Author MinjieZhang
 * @Date 2023-03-03 19:32
 */
public class Question7 {
    public static void main(String[] args) {
        int n = 49;
        /*
        递归=递归体+递归出口
        5%2=2....1
        2%2=1....0
        1%2=0.....1
        0%2=0
         */
        System.out.print("十进制 "+n);
        System.out.print(" 的二进制为：");
        tenIntoBin(n);
    }

    public static int tenIntoBin(int dividend) {
        //dividend是被除数
        if (dividend == 0) {
            //递归出口
            return 1;
        }

        //reamainder 此次除法的余数
        int remainder = dividend % 2;

        //temp 下一次的被除数
        int temp = dividend / 2;

        tenIntoBin(temp);
        System.out.print(remainder);
        return remainder;
    }
}
