package month2.week5.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 假如我们拥有一个 学生列表,我们要对这个学生列表进行处理得到来自北京同学, 并且高度最高的三个同学
 * (需要提前看一下TreeMap, 或者TreeSet来实现. 为明天的Stream课程做基础)
 *
 * @Author MinjieZhang
 * @Date 2023-04-01 22:48
 */
public class Question4 {
    public static void main(String[] args) {

        StudentList st = new StudentList();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
    }
}

class StudentList {
    public List<Person> personList;

    public StudentList() {
        this.personList = new ArrayList<>();

        personList.add(new Person("aa", 18, 170, Person.Address.BJ));
        personList.add(new Person("bb", 20, 163, Person.Address.SH));
        personList.add(new Person("cc", 30, 182, Person.Address.WH));
        personList.add(new Person("dd", 16, 190, Person.Address.BJ));
        personList.add(new Person("ee", 15, 210, Person.Address.SH));
        personList.add(new Person("ff", 17, 160, Person.Address.WH));
        personList.add(new Person("gg", 18, 169, Person.Address.BJ));
        personList.add(new Person("hh", 20, 173, Person.Address.WH));
        personList.add(new Person("ii", 22, 192, Person.Address.SH));
        personList.add(new Person("jj", 25, 172, Person.Address.SH));
        personList.add(new Person("kk", 24, 188, Person.Address.BJ));
        personList.add(new Person("ll", 17, 161, Person.Address.WH));
        personList.add(new Person("mm", 18, 169, Person.Address.SH));
        personList.add(new Person("nn", 20, 162, Person.Address.BJ));
        personList.add(new Person("oo", 22, 166, Person.Address.SH));
        personList.add(new Person("pp", 24, 176, Person.Address.WH));
        personList.add(new Person("qq", 22, 173, Person.Address.BJ));
        personList.add(new Person("rr", 24, 177, Person.Address.BJ));
        personList.add(new Person("ss", 17, 169, Person.Address.SH));
        personList.add(new Person("tt", 18, 170, Person.Address.SH));
        personList.add(new Person("uu", 20, 171, Person.Address.WH));
        personList.add(new Person("vv", 22, 172, Person.Address.WH));
        personList.add(new Person("ww", 24, 181, Person.Address.BJ));
        personList.add(new Person("xx", 18, 188, Person.Address.SH));
        personList.add(new Person("yy", 20, 183, Person.Address.BJ));
        personList.add(new Person("zz", 22, 191, Person.Address.WH));

    }

}

class Person implements Comparable<Person> {
    public Person(String name, int age, int height, Address address) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.address = address;
    }

    @Override
    public int compareTo(Person o) {
        if (!this.address.equals(o.address)) {
            return this.address.hashCode() - o.address.hashCode();
        }
        //城市相同
        
        return this.height - o.height;
    }

    public enum Address {
        BJ,
        SH,
        WH,
        SZ
    }

    private String name;
    private int age;
    private int height;
    private Address address;
}