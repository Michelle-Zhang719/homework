package month1.week2.day2;

/**
 * 综合访问权限修饰符，static等知识点，做一个综合的练习。
 * 定义一个Student类，并要求在其他类中，最多只能创建10个Student类的对象。
 * 分析：
 * 1，如果允许外部直接创建对象，显然无法控制创建对象的个数
 * 2，需要计数器指示外部创建对象的个数
 * <p>
 * 1、私有化构造方法
 * 2、只能在内部创建，并返回该对象（通过Student类内部的方法）
 * 需要一个计数器count指示当前类创建了多少次对象（count必须是类所有，全体对象共享）
 *
 * @Author MinjieZhang
 * @Date 2023-03-07 22:32
 */
public class Question5_correct {
    public static void main(String[] args) {
        //Student student = new Student();    //error
        for (int i = 0; i <= 10; i++) {
            Student.createNew();
        }
    }
}

class Student {
    //私有化构造方法
    private Student() {
    }

    //只能在内部创建，并返回该对象
    //需要一个计数器count指示当前类创建了多少次对象
    // 普通成员变量为对象所有，每创建一次就有一个新的，不可以）（核心要点：count必须是类所有，全体对象共享）
    //把创建Student对象的工作，交给一个专门的方法去做
    static int i = 1;
    public static Student createNew() {
        //这个时候仍然可以创建对象
        if (i <= 10) {
            System.out.println("创建的第" + i + "个Student对象");
            Student student = new Student();
            i++;
            return student;
        } else {
            System.out.println("创建对象失败，最多只能创建10个Student类的对象。");
            return null;
        }
    }
}