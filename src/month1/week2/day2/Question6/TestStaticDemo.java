package month1.week2.day2.Question6;

/**
 * Question6
 * 读下列代码，也可以将代码拷入IDEA运行查看结果，思考为什么代码会这样运行？
 * 要想搞明白这道题，需要先把文档中，第10节 代码块那一节的“类加载补充”小节看一下。先自己思考思考，不行可以互相讨论讨论，问问老师。
 *
 * 第一段代码：
 * 类初始化步骤完成之前，这个类就可以创建对象了。创建对象，不依赖于完成类加载（初始化）。
 * 某个类一旦开始进行初始化，就不会再重复进行一次初始化了！
 *          main方法启动已经使JVM开始初始化类TestStaticDemo了，
 *          即便初始化过程需要创建TestStaticDemo对象，也不会又一次开始初始化类TestStaticDemo了。直接创建对象即可。
 * 框1输出内容为创建类TestStaticDemo的对象ts时，输出的内容，顺序为 无参代码块-->显示赋值a--->无参构造器
 * 框2为TestStaticDemo类加载时，此时的b才被显示赋值输出内容
 * 框3为，类加载完毕，main方法栈帧进栈，执行时输出内容
 * @Author MinjieZhang
 * @Date 2023-03-07 21:153
 */
//public class TestStaticDemo {
//    public static void main(String[] args) {
//        staticMethod();
//    }
//
//    static TestStaticDemo ts = new TestStaticDemo();
//
//    static {
//        System.out.println("静态代码块");
//    }
//
//    {
//        System.out.println("构造代码块");
//    }
//
//    public TestStaticDemo() {
//        System.out.println("无参构造器");
//        System.out.println("a=" + a + ",b=" + b);
//    }
//
//    public static void staticMethod() {
//        System.out.println("静态成员方法");
//    }
//
//    int a = 666;
//    static int b = 777;
//}
//上述代码稍微改一下，思考代码的输出结果会如何变化？

public class TestStaticDemo {
    public static void main(String[] args) {
        staticMethod();
    }

    static TestStaticDemo ts = new TestStaticDemo();

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }

    public TestStaticDemo() {
        System.out.println("无参构造器");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticMethod() {
        System.out.println("静态成员方法");
    }

    int a = 666;
    static int b = 777;
    static TestStaticDemo ts2 = new  TestStaticDemo();
}