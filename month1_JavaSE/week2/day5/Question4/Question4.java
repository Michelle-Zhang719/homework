package month1_JavaSE.week2.day5.Question4;

/**
 * 请根据题目，作出合理设计，定义如下类：
 * 父类Person
 * 属性：String name，int age
 * 行为：eat();
 * 子类SouthPerson
 * 属性：String name，int age，double salary
 * 行为：eat()，swim()
 * 子类NorthPerson
 * 属性：String name，int age，double height
 * 行为：eat()，drink()
 * <p>
 * 写代码实现，eat()方法的多态效果
 * 1，人都要吃饭
 * 2，南方人喜欢吃米饭
 * 3，北方人喜欢吃面食
 * 最后，在测试类中，编写测试代码，要求进行如下测试：
 * 1，编写测试方法，
 * 要求该方法允许传入SouthPerson对象和NorthPerson对象，并在方法体中调用它们的eat()方法
 * 方法调用的结果一致吗？
 * 2，用父类引用指向子类对象的方式创建SouthPerson对象，能否直接访问salary属性和swim()方法？
 * 如果不能，应该怎么写代码让它能够正常调用？
 * 3，用父类引用指向子类对象的方式创建NorthPerson对象，能否（直接或写代码）访问salary属性和swim()方法？
 * 如果不能，将该对象引用强转为SouthPerson引用，能否成功？为什么？
 * <p>
 * 答：
 * 1.不一致
 * 2.不能，强制转换
 * 3.不能，不能成功，强转只能发生在一条继承链上
 *
 * @Author MinjieZhang
 * @Date 2023-03-10 20:04
 */
public class Question4 {
    private static Person sp;

    public static void main(String[] args) {
        //代码实现，eat()方法的多态效果
        Person sp;
        sp = new Person();
        sp.eat();
        sp = new SouthPerson();
        sp.eat();
        sp = new NorthPerson();
        sp.eat();


        //测试代码
        //1.允许传入SouthPerson对象和NorthPerson对象，并在方法体中调用它们的eat()方法
        test1(new SouthPerson(), new NorthPerson());

        //2，用父类引用指向子类对象的方式创建SouthPerson对象，能否直接访问salary属性和swim()方法？
        Person sp2 = new SouthPerson();
        if (sp2 instanceof SouthPerson) {
            System.out.println(((SouthPerson) sp2).salary);
            ((SouthPerson) sp2).swim();
        }

        //3，用父类引用指向子类对象的方式创建NorthPerson对象，能否（直接或写代码）访问salary属性和swim()方法？
        Person sp3 = new NorthPerson();
        if (sp3 instanceof SouthPerson) {
            System.out.println("可以强转");
        } else {
            System.out.println("不能强转");
        }

    }


    //测试代码
    //1.允许传入SouthPerson对象和NorthPerson对象，并在方法体中调用它们的eat()方法
    public static void test1(Person sp1, Person sp2) {
        sp1.eat();
        sp2.eat();
    }
}

class Person {
    String name;
    int age;

    void eat() {
        System.out.println("人都要吃饭");
    }
}

class SouthPerson extends Person {
    double salary = 400000;

    @Override
    void eat() {
        System.out.println("南方人喜欢吃米饭");
    }

    void swim() {
        System.out.println("南方人在游泳");
    }
}

class NorthPerson extends Person {
    double height;

    @Override
    void eat() {
        System.out.println("北方人喜欢吃面食");
    }

    void drink() {
        System.out.println("北方人在喝酒");
    }
}