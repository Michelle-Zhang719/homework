package week2.day5;

/**
 * final修饰成员/静态成员变量，表示一个常量，必须明确地赋值。
 * 自定义一个类，类中定义三个成员变量a，b，c，用final修饰这三个成员变量
 * 再定义两个静态成员变量staticA和staticB，也用final修饰这两个静态成员变量
 * 然后：
 * 1，请用三种不同的方式，分别为成员变量a，b，c赋值
 * 2，请用两种不同的方式，分别为静态成员变量staticA和staticB赋值
 * <p>
 * 答:
 * 成员常量的赋值，有且必须有一次（在创建对象过程中）  = 显示赋值 + 构造代码块 + 构造器
 * 全局常量 （在类加载过程中）赋值 = 显示赋值 + 静态代码块
 *
 * @Author MinjieZhang
 * @Date 2023-03-10 19:18
 */
public class Question3 {
    public static void main(String[] args) {

//        //显示赋值
//        CustomClass cs1 = new CustomClass();
//        cs1.print();

//        //构造代码块赋值
//        CustomClass cs2 = new CustomClass();
//        cs2.print();

        //构造器赋值
//        CustomClass cs3 = new CustomClass(7, 8, 9);
//        cs3.print();

        System.out.println(CustomClass.staticA);
        System.out.println(CustomClass.staticB);
    }
}


class CustomClass {

//    //显示赋值
//    public final int a = 1;
//    public final int b = 2;
//    public final int c = 3;

    public final int a;
    public final int b;
    public final int c;
//
//    //构造代码块赋值
//    {
//        a = 4;
//        b = 5;
//        c = 6;
//    }

    //构造器赋值
    public CustomClass(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //显示赋值
    public static final int staticA = 10;
    public static final int staticB = 20;

//    public static final int staticA;
//    public static final int staticB;
//
//    //静态代码块赋值
//    static {
//        staticA = 30;
//        staticB = 40;
//    }


    public void print() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}