package week3.day1;

/**
 * 用内部类来实现接口
 * 定义一个接口Compute，用来完成计算器的功能，比如最简单的加减乘除功能。
 * 请用以下两种方式测试：
 * 1，编写实现类进行测试
 * 2，用局部内部类进行测试
 * 3，使用匿名内部类进行测试
 *
 * @Author MinjieZhang
 * @Date 2023-03-13 20:29
 */
public class Question7 {
    public static void main(String[] args) {
        //1.实现类
        Normal n = new Normal();
        System.out.println(n.calculate("*", 2, 10));

        //2.局部内部类
        class Local implements Compute {

            @Override
            public double calculate(String op, int x, int y) {
                switch (op) {
                    case "+":
                        return x + y;
                    case "-":
                        return x - y;
                    case "*":
                        return x * y;
                    case "/":
                        return x / y;
                    default:
                        return -1;
                }
            }
        }
        Local l = new Local();
        System.out.println(l.calculate("+", 10, 12));

        //3.匿名内部类
        System.out.println(new Compute() {
            @Override
            public double calculate(String op, int x, int y) {
                switch (op) {
                    case "+":
                        return x + y;
                    case "-":
                        return x - y;
                    case "*":
                        return x * y;
                    case "/":
                        return x / y;
                    default:
                        return -1;
                }
            }
        }.calculate("/", 10, 2));
    }
}

interface Compute {
    //op 操作  x y被操作数
    double calculate(String op, int x, int y);
}

class Normal implements Compute {

    @Override
    public double calculate(String op, int x, int y) {
        switch (op) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                return -1;
        }
    }
}