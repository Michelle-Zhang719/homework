package week2.day3;

import java.util.Scanner;

/**
 * /*
 * 定义一个银行账户类Account, 3个属性, 用户名, 密码, 余额.
 * 要求用户名长度4-6位
 * 密码长度6位
 * 余额大于100
 *
 * @Author MinjieZhang
 * @Date 2023-03-08 21:54
 */

public class Question2_correct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account ac = new Account();
        System.out.println("请输入4-6位的用户名：");
        ac.setUserName(sc.nextLine());
        System.out.println("请输入6位的密码：");
        ac.setPassword(sc.nextLine());
        System.out.println("请输入余额（最低100）：");
        ac.setBalance(sc.nextDouble());

        System.out.println("此账户的用户名为：" + ac.getUserName());
        System.out.println("密码为：" + ac.getPassword());
        System.out.println("余额为：" + ac.getBalance());

    }

}
class Account {
    private String userName;
    private String password;
    private double balance;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        // 要求用户名长度4-6位
        int length = userName.length();
        if (length >= 4 && length <= 6) {
            this.userName = userName;

        } else {
            System.out.println("用户名长度要求4-6位");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // 密码长度6位
        if (password.length() == 6) {
            this.password = password;

        } else {
            System.out.println("密码必须为6");
        }
    }

    public double getBalance() {
        //余额大于100
        if (balance >= 100) {
            return balance;

        } else {
            System.out.println("余额不足!");
            return 0;
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
