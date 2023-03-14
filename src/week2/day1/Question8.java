package week2.day1;

/**
 * 定义一个Student类：
 * 成员变量：String name，int stuId，String gender，int age，double score（表示学生Java考试成绩）
 * 构造器：无参构造器，全参构造器等，自由发挥。
 * 成员方法：print()，打印对象所有属性的取值。
 * 类定义完毕后，创建五个Student对象存入Student对象数组中，完成以下两个操作：
 * 1. 遍历输出每个学生的属性信息（遍历对象调用print()方法）
 * 2. 求成绩平均值。
 * 注：
 * 1. 数组既可以存储基本数据类型（的值），也可以存储引用数据类型（的引用）。它们的使用没有本质区别。
 * 2. 可以考虑提取方法实现功能，不要把所有代码一股脑写在main方法中。
 *
 * @Author MinjieZhang
 * @Date 2023-03-06 20:19
 */
public class Question8 {
    public static void main(String[] args) {
        Student[] stuArr = new Student[5];
        stuArr[0] = new Student("张三", 1, "男", 18, 99);
        stuArr[1] = new Student("李四", 2, "女", 19, 79);
        stuArr[2] = new Student("王五", 3, "男", 20, 69);
        stuArr[3] = new Student("赵六", 4, "女", 21, 89);
        stuArr[4] = new Student("路人", 5, "男", 22, 78);

        printCharacterC(stuArr);
        getAverScore(stuArr);
    }

    private static void getAverScore(Student[] stuArr) {
        double sumScore = 0;
        for (Student student : stuArr) {
            sumScore += student.score;
        }
        double averScore = sumScore / 5.0;
        System.out.println("Java成绩平均值为：" + averScore);
    }

    private static void printCharacterC(Student[] stuArr) {
        for (Student student : stuArr) {
            System.out.println("姓名：" + student.name + " 学生号：" + student.stuId + " 性别:" + student.gender + " 年龄：" + student.age + " Java考试成绩：" + student.score);

        }
    }


}

class Student {
    String name;
    int stuId;
    String gender;
    int age;
    //学生Java考试成绩
    double score;

    public Student(String name, int stuId, String gender, int age, double score) {
        this.name = name;
        this.stuId = stuId;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    public void print(Student[] stuArr) {
        for (Student student : stuArr) {
            System.out.println("姓名：" + student.name + " 学生号：" + student.stuId + " 性别：" + student.gender + " Java考试成绩：" + student.score);
        }

    }
}