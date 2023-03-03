package month1.week1.day5;

/**
 * 值传递练习
 * Java有且仅有值传递，Java中的方法不能直接改变实参本身。
 * 对于下列代码：
 * public static void main(String[] args) {
 * int a = 10;
 * int b = 20;
 * method(a, b);
 * System.out.println("a = " + a);
 * System.out.println("b = " + b);
 * }
 *
 * public static void method(int a, int b) {
 * a *= 2;
 * b *= 2;
 * }
 * 思考以下问题：
 * 对于以上Java代码，method()方法可以把a，b的取值变为原先的2倍吗？如果不能，为什么？
 * 上述main方法不变，修改method方法实现，让程序输出：
 * a = 20
 * b = 40
 * 如何实现呢？
 * 注：这是个脑筋急转弯，不会的可以互相问问或者查一查百度吧。
 * @Author MinjieZhang
 * @Date 2023-03-03 21:31
 */
public class Question5 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        method(a, b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void method(int a, int b) {
        a *= 2;
        b *= 2;
    }
}
