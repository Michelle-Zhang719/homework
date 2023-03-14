package week2.day1;

/**
 * 编写一个类模拟银行账户（Account）的功能，包含的属性有"账户名（ID）"、"密码"、"账户余额"、"储蓄年利率"等。 其中：
 * 账号名：要求每个账户的账户名都是唯一的，且按照固定格式自动生成：
 * 第一位账户的账户名是"10001"
 * 其后账户的账户名依次加1。比如第二位账户的账户名就是"10002"，第三位就是"10003".....
 * 密码：新建账户时，可以选择自定义密码，也可以选择使用默认密码："000000"（6个0）
 * 账户余额：可以选择在新建账户时预设一个值，也可以保持默认值0
 * 储蓄年利率：由银行设置，和账户本身没有关系。你可以将它设置为"0.3%"（活期年利率一般都非常低，聊胜于无）
 * 定义完属性后，再给出两个成员方法：
 * 1，打印账户自身所有属性。2，根据传入的年限和储蓄年利率，计算本息合计后的余额。
 * 注：计算利息时简单点，不考虑利滚利。即利息 = 利率 * 时间 * 本金
 *
 * @Author MinjieZhang
 * @Date 2023-03-06 19:17
 */
public class Question6 {
    public static void main(String[] args) {
        Account user1 = new Account("123456", 100);
        user1.printInfo();
        user1.getAccBalance(2);

        Account user2 = new Account(200);
        user2.printInfo();
        user2.getAccBalance(2);

        Account user3 = new Account("678901");
        user3.printInfo();
        user3.getAccBalance(3);

        Account user4 = new Account();
        user4.printInfo();
        user4.getAccBalance(2);
    }
}

class Account {
    static int ID = 10000;
    String pwd = "000000";
    double balance = 0;
    //储蓄年利率，全体对象共享
    static double yearRate = 0.003;

    //都是用默认
    public Account() {
        ID++;
    }

    public Account(String pwd, double balance) {

        this.pwd = pwd;
        this.balance = balance;
        ID++;
    }

    //默认余额
    public Account(String pwd) {
        this.pwd = pwd;
        ID++;
    }

    //默认密码
    public Account(double balance) {
        this.balance = balance;
        ID++;
    }

    public void printInfo() {
        System.out.println("账户名（ID）:" + ID);
        System.out.println("密码:" + pwd);
        System.out.println("账户余额:" + balance);
        System.out.println("储蓄年利率:" + yearRate);
    }

    public void getAccBalance(int year) {
        //利息
        double interest = 0;
        interest = yearRate * year * balance;
        balance = balance + interest;
        System.out.println("本息合计后的余额为：" + balance);
        System.out.println();
    }
}
