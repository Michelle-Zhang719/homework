package week2.day1;

/**
 * 静态成员变量的赋值顺序debug模式练习：
 * @Author MinjieZhang
 * @Date 2023-03-06 21:31
 */

public class Question9 {
    public static void main(String[] args) {
        Person p = new Person(18);
    }
}
class Person {
    int age = 10;
    static String nationality = "美国";

    public Person(int age) {
        this.age = age;
    }


    public Person() {
    }

    public Person(String nationality) {
        Person.nationality = nationality;
    }
}