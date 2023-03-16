package week3.day3;

/**
 * 深度克隆练习
 * 分别定义以下类：
 * 教师类Teacher
 * 属性：int age;String name;Student stu
 * 学生类Student
 * 属性：int age；String name；Star s
 * 明星类Star
 * 属性：int age，String name
 * 尝试完成Teacher对象的深度克隆，并写代码进行测试
 * 注：String虽然也是引用数据类型，但无需考虑对它的对象进行深度克隆。
 *
 * @Author MinjieZhang
 * @Date 2023-03-15 17:28
 */
public class Question1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher t = new Teacher(28, "张三", new Student(18, "李四", new Star(11, "王五")));
        Teacher clone = t.clone();
        clone.stu.s.name = "明星";
        System.out.println(t.stu.s.name);
        System.out.println(clone.stu.s.name);

    }
}

class Teacher implements Cloneable {
    int age;
    String name;
    Student stu;

    public Teacher(int age, String name, Student stu) {
        this.age = age;
        this.name = name;
        this.stu = stu;
    }

    @Override
    protected Teacher clone() throws CloneNotSupportedException {
        // 1.深度克隆是在浅克隆的基础上完成的,所以首先仍然要做浅克隆
        Teacher cloneTeacher = (Teacher) super.clone();
        // 2.对象中引用数据类型成员变量引用指向的对象克隆一份
        Student cloneStudent = stu.clone();
        // 3.让克隆对象中的引用数据类型拷贝引用指向新的拷贝对象
        cloneTeacher.stu = cloneStudent;
        return cloneTeacher;
    }
}

class Student implements Cloneable {
    int age;
    String name;
    Star s;

    public Student(int age, String name, Star s) {
        this.age = age;
        this.name = name;
        this.s = s;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student cloneStudent = (Student) super.clone();
        Star cloneStar = s.clone();
        cloneStudent.s = cloneStar;
        return cloneStudent;
    }
}

class Star implements Cloneable {
    int age;
    String name;

    public Star(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected Star clone() throws CloneNotSupportedException {
        return (Star) super.clone();
    }
}