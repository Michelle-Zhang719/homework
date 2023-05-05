package month1_JavaSE.week2.day6;

/**
 * 接口与抽象类基础语法练习
 * 从实际角度出发，接口和抽象类的差异是十分明显的。可以参考完成以下案例：
 * <p>
 * 学生和老师都有共同的属性: name、gender、age
 * 共同的行为：eat() sleep()
 * 注：虽然行为一致，但实现会不同。
 * 现在为了提升自身素质，大家都需要额外进行技能的学习：学生需要增强实践动手能力，老师需要增强语言能力。
 * 请定义抽象类和接口，描述以上体系。
 * 然后用以下方式进行测试：
 * 1，用不同的父类指向不同的子类对象，理解方法调用时“编译时看左边”
 * 2，用这些引用调用方法，理解方法调用时“运行时看右边”
 *
 * 答：
 * 编译（访问范围）看左边，运行时（调用结果）看右边。
 *
 * @Author MinjieZhang
 * @Date 2023-03-11 14:35
 */
public class Question4 {
    public static void main(String[] args) {
        //1，用不同的父类指向不同的子类对象，理解方法调用时“编译时看左边”
        //很明显，父类引用指向子类对象时，访问范围不包括子类独有的方法，但时在子类中重写的方法会运行
        Person p1 = new Student();
//        p1.actionAbility();
        p1.sleep();
        p1.eat();

        Person p2 = new Teacher();
//        p2.languageAbility();
        p2.sleep();
        p2.eat();

        Student s = new Student();
        s.actionAbility();
        s.sleep();
        s.eat();

        Teacher t = new Teacher();
        t.languageAbility();
        t.eat();
        t.sleep();
    }
}

class Person {
    String name;
    String gender;
    int age;

    void eat() {
        System.out.println("人得吃饭");
    }

    void sleep() {
        System.out.println("人得睡觉");
    }
}

interface ActionAbility {
    void actionAbility();

}

interface LanguageAbility {
    void languageAbility();

}

class Student extends Person implements ActionAbility {
    @Override
    void sleep() {
        System.out.println("学生在睡觉");
    }

    @Override
    void eat() {
        System.out.println("学生在吃饭");
    }

    @Override
    public void actionAbility() {
        System.out.println("学生需要增强实践动手能力");
    }
}

class Teacher extends Person implements LanguageAbility {

    @Override
    void sleep() {
        System.out.println("老师在睡觉");
    }

    @Override
    void eat() {
        System.out.println("老师在吃饭");
    }

    @Override
    public void languageAbility() {
        System.out.println("老师需要增强语言能力");
    }
}