package month1.week2.day4;

import org.junit.Test;

/**
 * 使用alt + insert快捷键可以快速生成各种类中结构。子类继承父类后，在子类中按alt + insert快捷键快速创建构造方法时，
 * 第一步会让你选择父类构造器（也就是super(参数)）随后才是选择子类自身的成员变量，生成子类构造器。
 * 当选择使用父类无参构造器，这时super()是隐藏的，即子类对象隐式初始化。
 * 当选择使用子类有参构造器时，这时super(参数)必须写在子类构造器第一行，这是子类对象的显式初始化。
 * <p>
 * 题目:
 * 给出三个层级的继承关系
 * 顶层父类Grandfather，Father继承Grandfather，Son继承Father
 * 三个类的成员变量分别是（变量的类型是int）：
 * Grandfather类，有两个成员变量：gA,a
 * Father类，有两个成员变量：fA,a
 * Son类，有两个成员变量：sA,a
 * <p>
 * 成员方法（方法体写一个能够区分的输出语句就行）：
 * Grandfather：testGrand,test
 * Father：testFather,test
 * Son：testSon,test
 * <p>
 * 使用快捷键在Son中生成不同的构造方法，调用不同的父类构造器（需要先生成父类相应的构造器）
 * 随后使用多种方式创建Son对象，测试对象名访问成员的机制，理解属性隐藏和方法覆盖。
 * 该题目单纯练习语法和测试代码，不用思考过多。
 *
 * 答：
 * 属性隐藏：
 * 父子类存在同名成员变量 （a） 的情况下，创建子类对象用子类引用指向，再用这个子类引用访问父子类同名成员变量会得出子类中的结果
 * 对象名点成员变量，它的访问范围是由引用的数据类型来决定的。
 *
 *
 *方法覆盖：
 * 访问范围：对象名点成员方法，它的访问范围是由 引用的数据类型 来决定的。
 * 访问结果：对象名点成员方法，访问的结果就不再是由 引用的数据类型 来决定了，而是根据 对象的实际类型 来决定。
 * @Author MinjieZhang
 * @Date 2023-03-09 19:43
 */
public class Question7 {
    public static void main(String[] args) {
        Son s1 = new Son(1, 2, 3, 4, 5, 6);
        Father s2 = new Son(10);
        Grandfather s3 = new Son(100);

        s1.test();
        s1.testSon();
        s1.testGrand();
        s1.testFather();
        System.out.println(s1.a);
        System.out.println();

        s2.test();
//        s2.testson;
        s2.testGrand();
        s2.testFather();
        System.out.println(s1.a);
        System.out.println();

        s3.test();
//        s3.testSon;
//        s3.testFather();
        s3.testGrand();
        System.out.println(s1.a);
    }
}

class Grandfather {
    int gA;
    int a;

    public void testGrand() {
        System.out.println("祖父类中成员方法");
    }

    public void test() {
        System.out.println("祖父类中test方法");

    }

    //双参
    public Grandfather(int gA, int a) {
        this.gA = gA;
        this.a = a;
    }

    public Grandfather() {
    }
}

class Father extends Grandfather {
    int fA;
    int a;

    public void testFather() {
        System.out.println("父类中成员方法");
    }

    public void test() {
        System.out.println("父类中test方法");

    }

    //双参
    public Father(int gA, int a, int fA, int a1) {
        super(gA, a);
        this.fA = fA;
        this.a = a1;
    }

    public Father(int a) {
        this.a = a;
    }
}

class Son extends Father {
    int sA;
    int a;

    public void testSon() {
        System.out.println("儿子类中成员方法");
    }

    public void test() {
        System.out.println("儿子类中test方法");

    }

    //单参构造
    public Son(int gA, int a, int fA, int a1, int sA) {
        super(gA, a, fA, a1);
        this.sA = sA;
    }

    //双参构造
    public Son(int gA, int a, int fA, int a1, int sA, int a2) {
        super(gA, a, fA, a1);
        this.sA = sA;
        this.a = a2;
    }

    public Son(int a) {
        super(a);
    }
}