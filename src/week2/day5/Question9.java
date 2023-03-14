package week2.day5;

/**
 * 完成抽象类的基础语法练习，按照说明操作即可。
 * 定义抽象类A，抽象类B继承A，普通类C继承B。
 * A类中，定义成员变量a赋值为10，抽象showA方法
 * B类中，定义成员变量b赋值为20，抽象showB方法
 * C类中，定义成员变量c赋值为30，重写showA方法打印a，重写showB方法打印b，定义showC方法，打印c
 * 然后在测试类中，创建C类的对象，调用showA方法，showB方法，showC方法。
 * 然后查看方法调用结果，思考为什么会出现这种现象。
 * <p>
 * 答：a b c变量都是c的成员变量，故输出为显示赋值的结果
 *
 * @Author MinjieZhang
 * @Date 2023-03-10 20:59
 */
public class Question9 {
    public static void main(String[] args) {
        C c = new C();
        c.showA();
        c.showB();
        c.showC();
    }
}

//抽象类a
abstract class A {
    int a = 10;

    abstract void showA();

}

//抽象类B
abstract class B extends A {
    int b = 20;

    abstract void showB();

}

//抽象类C
class C extends B {
    int c = 30;

    @Override
    void showA() {
        System.out.println(a);
    }

    @Override
    void showB() {
        System.out.println(b);
    }

    void showC() {
        System.out.println(c);
    }
}
