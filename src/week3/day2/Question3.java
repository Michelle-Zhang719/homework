package week3.day2;

/**
 * Lambda表达式的书写，除了注意格式外，最重要的是关注类型推断
 * 提供以下6个功能接口，请用lambda表达式分别创建对象，调用test()方法
 * 自由发挥lambda表达式的书写
 * <p>
 * 答：
 * 基础使用
 * 1.直接用父接口引用接收
 * 2.直接告诉编译器Lambda表达式是哪个接口的子类对象
 * 3.借助方法完成类型推断 3.1方法的返回值数据类型 3.2方法的形参的数据类型
 * <p>
 * 进阶使用：格式简化
 * 1.(形参列表)简化
 * 2.{ //方法体 }方法体简化
 * 3.方法引用
 *
 * @Author MinjieZhang
 * @Date 2023-03-14 21:03
 */
public class Question3 {
    public static void main(String[] args) {
        System.out.println("----直接用父接口引用接收+方法体简化----");
        INoReturnNoParam nrnp = () -> System.out.println("我是无返回值有一个参数的功能接口");
        nrnp.test();

        System.out.println("----直接告诉编译器Lambda表达式是哪个接口的子类对象----");
        ((INoReturnOneParam) ((int a) -> {
            System.out.println("我是无返回值两个参数的功能接口" + a);
        })).test(3);

        System.out.println("----借助方法的返回值数据类型----");
        method1().test();

        System.out.println("----借助方法的形参的数据类型 + (形参列表)简化----");
        // 使用Lambda表达式创建接口IHasReturnOneParam的子类对象
        IHasReturnOneParam hrop = (a) -> {
            System.out.println("我是有返回值一个参数的功能接口");
            return a;
        };
        hrop.method(30);

        System.out.println("----方法引用----");
        IHasReturnTwoParam hrtp = Question3::test;
        hrtp.test(2,3);
    }

    public static IHasReturnNoParam method1() {
        return ()->{
            System.out.println("我是有返回值无参数的功能接口");
            return 0;
        };
    }

    private static int test(int a, int b) {
        System.out.println("我是有返回值两个参数的功能接口");
        return a * b;
    }
}

//无返回值无参数的功能接口
@FunctionalInterface
interface INoReturnNoParam {
    void test();
}

//无返回值有一个参数的功能接口
@FunctionalInterface
interface INoReturnOneParam {
    void test(int a);
}

//无返回值两个参数的功能接口
@FunctionalInterface
interface INoReturnTwoParam {
    void test(int a, int b);
}

//有返回值无参数的功能接口
@FunctionalInterface
interface IHasReturnNoParam {
    int test();
}

//有返回值一个参数的功能接口
@FunctionalInterface
interface IHasReturnOneParam {
    int method(int a);
}

//有返回值两个参数的功能接口
@FunctionalInterface
interface IHasReturnTwoParam {
    int test(int a, int b);
}