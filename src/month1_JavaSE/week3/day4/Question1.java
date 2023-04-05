package month1_JavaSE.week3.day4;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 编写一个Cat类
 * 成员变量：
 * int age，
 * String name，
 * double price
 * 按以下要求进行自然排序：
 * 1，直接实现Comparable接口，按照年龄的从小到大对Cat数组进行自然排序
 * 2，利用Comparator接口，用匿名内部类和lambda分别对Cat数组进行自然排序
 * 2.1，按照price的大到小排序
 * 2.2 name的长短排序，name越长对象越大
 * 2.3 综合age，name，price进行排序，要求用lambda表达式指向一个方法。
 * 排序的规则是age越小对象越小，age相同比较name长短，name越短对象越小，name长度也相等，比较price，price越大对象越小
 *
 * @Author MinjieZhang
 * @Date 2023-03-16 19:43
 */
public class Question1 {
    static Cat[] cats = new Cat[5];

    static {
        cats[0] = new Cat(12, "喵喵喵", 200);
        cats[1] = new Cat(9, "哼哼", 100);
        cats[2] = new Cat(9, "汪汪", 20);
        cats[3] = new Cat(9, "嗯", 30);
        cats[4] = new Cat(2, "哈", 500);
    }

    @Test
    public void test() {
        System.out.println("1，直接实现Comparable接口，按照年龄的从小到大对Cat数组进行自然排序");
        Arrays.sort(cats);
        print(cats);
    }


    @Test
    public void test2() {
        System.out.println("2，利用Comparator接口，用匿名内部类和lambda分别对Cat数组进行自然排序");
        System.out.println("    2.1，按照price的大到小排序----匿名内部类实现");
        Arrays.sort(cats, new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return (int) (o2.price - o1.price);
            }
        });
        print(cats);
    }

    @Test
    public void test3() {
        System.out.println("2，利用Comparator接口，用匿名内部类和lambda分别对Cat数组进行自然排序");
        System.out.println("    2.2 name的长短排序，name越长对象越大越靠后----lambda实现");
        Arrays.sort(cats, ((o1, o2) -> o1.name.length() - o2.name.length()));
        print(cats);
    }

    @Test
    public void test4() {
        System.out.println("2，利用Comparator接口，用匿名内部类和lambda分别对Cat数组进行自然排序");
        System.out.println("    2.3综合age，name，price进行排序------lambda表达式指向方法");
        System.out.println("       排序的规则:age越小对象越小，age相同比较name长短，name越短对象越小，name长度也相等，比较price，price越大对象越小");

        Arrays.sort(cats, (this::compare));
        print(cats);
    }

    private int compare(Cat o1, Cat o2) {
        if (o1.age != o2.age) {
            return o1.age - o2.age;
        }
        //age一样，比较name
        if (o1.name.length() != o2.name.length()) {
            return o1.name.length() - o2.name.length();
        }
        return (int) (o2.price - o1.price);

    }

    private void print(Cat[] cats) {
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }
}

class Cat implements Comparable<Cat> {
    int age;
    String name;
    double price;

    public Cat(int age, String name, double price) {
        this.age = age;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //1，直接实现Comparable接口，按照年龄的从小到大对Cat数组进行自然排序
    @Override
    public int compareTo(Cat cat) {
        return age - cat.age;
    }

}