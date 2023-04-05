package month1_JavaSE.week2.day2;

/**
 * 设计一个员工类(Staff)，要求该类：
 * 属性: 姓名,性别,工号,工资
 * 构造器:
 * 姓名的单参构造器、姓名和性别的双参构造器、姓名、性别和工资的三参构造器
 * 其中员工的工号要求(每一位员工都必须有工号):
 * 第一个员工对象的工号是10001
 * 第二个员工对象的工号是10002
 * 第三个员工对象的工号是10003
 * ....
 * 现在每位员工都要缴纳一个固定额的公积金（比如2000），要求在员工类中设计一个方法求员工的到手工资。（除了扣除这个固定额度的公积金，不考虑诸如扣税等其余问题）
 * 最后再定义一个方法用于打印员工对象的各种属性取值，其中在打印工资时，要打印实际到手工资。
 * 将该类定义完毕后，尝试创建对象，测试一下代码。
 *
 * @Author MinjieZhang
 * @Date 2023-03-07 21:37
 */
public class Question7 {
    public static void main(String[] args) {
        Staff s1 = new Staff("张三");
        Staff s2 = new Staff("李四","男");
        Staff s3 = new Staff("王五","女",3000);

        s1.print();
        s2.print();
        s3.print();
    }
}

class Staff {
    static int accumulationFund = 2000;
    static int initAccountId = 10000;


    int id ;
    String name;
    String gender;
    double salary;

    {
        initAccountId++;
        id = initAccountId;
    }


    //姓名、性别和工资的三参构造器
    public Staff(String name, String gender, double salary) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    //姓名和性别的双参构造器
    public Staff(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    // 姓名的单参构造器
    public Staff(String name) {
        this.name = name;
    }
    private double getFinalSalary(){
        if (salary<=0){
            return salary;
        }
        double finalSalary = salary - accumulationFund;
        return finalSalary;

    }
    public void print(){
        System.out.print("姓名:"+name);
        System.out.print(" 性别:"+gender);
        System.out.print(" 工号:"+id);
        System.out.println(" 工资:"+getFinalSalary());
        System.out.println();
    }

}