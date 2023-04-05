package month1_JavaSE.week3.day2;

/**
 * 对于Object类的getClass方法，做以下操作练习：
 * 1.随意定义两个类A和类B，然后创建2个A对象，1个B对象，三个对象分别调用getClass方法获取返回值Class对象。
 * 然后用"=="互相比较，比较的结果是什么呢？为什么有这样的比较结果呢？
 * 注：要去掉泛型，不要带着泛型用"=="比较。
 * <p>
 * 2.getClass方法可以获取某个类型的运行时类对象，而运行时类对象对于某一个类型而言是唯一的，
 * 所以getClass方法可以用于判断两个引用指向的对象是否是相同类型的对象。
 * 请写方法实现这个功能，要求：
 * 是同种类型对象返回true
 * 不是同种类型对象返回false
 *
 * 答：
 * 1.某个类的类加载在一次程序运行过程中，仅有一次。
 * 所以某个类的运行时类对象（Class对象）也必然是唯一的！！
 * 相对应的，不同类型的两个类，它们的Class对象必然是两个不同的独立对象。
 *
 * @Author MinjieZhang
 * @Date 2023-03-14 21:35
 */
public class Question5 {
    public static void main(String[] args) {
        A a1 = new A();
        Class a1Class = a1.getClass();
        A a2 = new A();
        Class a2Class = a2.getClass();
        B b = new B();
        Class bClass = b.getClass();

        System.out.println(a1Class == a2Class);
        System.out.println(a1Class == bClass);
        System.out.println(a2Class == bClass);

    }
}

class A {
    int a;

    public static void testA() {

    }
}

class B {
    int b;

    public static void testB() {

    }
}