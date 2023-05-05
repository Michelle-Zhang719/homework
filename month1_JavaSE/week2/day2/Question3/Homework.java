package month1_JavaSE.week2.day2.Question3;

/**
 * Question3
 * 查看如下代码，回答问题，问题写在注释部分。该题目可以练习Debug的使用。
 * 把该题当成一个简答题即可。
 * 问题1: 思考注释1下面的代码能否放开?会不会报错?
 * 问题2: 思考控制台输出的顺序,提供必要的文字说明解释代码为何如此执行。
 * 问题3: Homework building和Homework constructor会不会输出,为什么?
 * <p>

 * 1.可以放开。不会报错，s.age是Student类创建的对象s的属性值
 * 2.Homework类加载--->Student类加载完毕后---->创建Student类的对象s时，输出框1的构造代码块和构造器内容--->此时Homework类加载完毕
 *   main方法栈帧进站，输出框2内容
 *   Person类加载-->创建Student类对象s，输出框3内容--->Person类加载完成
 *   创建Person类对象p，输出框4的造代码块和构造器内容--->对象p创建完成
 *   输出对象p的属性名字，即刘备，框5内容
 * 3.不会，没有创建HomeWork的对象
 *
 * @Author MinjieZhang
 * @Date 2023-03-07 20:43
 */

public class Homework {
//    static Student s = new Student();

    {
        System.out.println("Homework building");
//        s = null;
    }

    public static void main(String[] args) {
        System.out.println("main");
        // 注释1
//         System.out.println(s.age);
//        Person p = new Person("刘备");
//        System.out.println(p.name);
    }

    public Homework() {
        System.out.println("Homework constructor");
    }
}

//class Person {
//    {
//        name = "赵云";
//        System.out.println("Person building");
//    }
//
//    String name = "曹操";
//    static Student s = new Student();
//
//    public Person() {
//    }
//
//    public Person(String name) {
//        System.out.println("Person constructor");
//        this.name = name;
//    }
//}
//
//class Student {
//    int age = 10;
//
//    {
//        System.out.println("Student building");
//        age = 20;
//    }
//
//    public Student(int age) {
//        this.age = age;
//    }
//
//    public Student() {
//        System.out.println("Student constructor");
//    }
//}