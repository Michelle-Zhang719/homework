package month1_JavaSE.week2.day3;

import java.util.Scanner;

/**
 * 继承基础语法练习
 * 提供以下两个动物需要描述，请用你的知识来编写代码
 * 猫：姓名，年龄，颜色，可以叫，可以抓老鼠
 * 狗：姓名，年龄，性别，可以叫，可以看门
 * 分析这个案例，设计出合适的继承体系。
 * 最后思考：人类研究出来了机器人，它们也有姓名，年龄，颜色等属性，可以套用本题中的继承体系吗？
 * <p>
 * 答：机器人类显然和动物没有is-a关系,不应该为了复用成员,强行使用继承！
 *
 * @Author MinjieZhang
 * @Date 2023-03-08 14:31
 */
public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //猫类
        Cat c = new Cat();
        System.out.println("请依次输入猫的姓名，颜色，年龄：");
        c.setName(sc.nextLine());
        c.setColor(sc.nextLine());
        c.setAge(sc.nextInt());
        c.printCharacter();
        sc.nextLine();
        //狗类
        Dog d = new Dog();
        System.out.println("请依次输入狗的姓名，性别，年龄");
        d.setName(sc.nextLine());
        d.setGender(sc.nextLine());
        d.setAge(sc.nextInt());
        d.printCharacter();
    }
}

//动物类
class Animal {
    private String name;
    private int age;


    public void call() {
        System.out.println("叫了两声");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

//猫类
class Cat extends Animal {
    private String color;

    public void catchMouse() {
        System.out.println("抓老鼠");
    }

    public void printCharacter() {
        System.out.println("物种：猫 姓名：" + getName() + " 年龄：" + getAge() + " 颜色：" + color);
        call();
        catchMouse();
    }

    public void setColor(String color) {
        this.color = color;
    }
}

//狗类
class Dog extends Animal {
    private String gender;

    public void watchDoor() {
        System.out.println("看门");
    }

    public void printCharacter() {
        System.out.println("物种：狗 姓名：" + getName() + " 年龄：" + getAge() + " 性别：" + gender);
        call();
        watchDoor();
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
