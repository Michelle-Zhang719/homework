package month1.week1.day1;

import java.util.Scanner;

/**
 * @Description 键盘录入某个人的工资收入，求他应该缴纳的个人所得税以及最后得到的工资。
 * 也就是说需要求两个值：缴纳的个税  到手工资
 * 个人所得税的计算方法是：
 * 应纳税额 = 应纳税所得额 * 税率 - 速算扣除数 （速算扣除额已经扣除了重复计算的部分）
 * 其中，应纳税所得额 = 工资薪金所得-2000（即工资超过2000的部分才需要缴税）
 * 针对不同的收入人群，需要缴纳个税的税率是不同的，详参下列表格：
 * 级数	应纳税所得额	税率（单位:%）	速算扣除数
 * 1	不超过500元的	5	0
 * 2	超过500元但是不超过2000的	10	25
 * 3	超过2000元但是不超过5000元的	15	125
 * 4	超过5000元但是不超过20000元的	20	375
 * 5	超过20000元但是不超过40000元的	25	1375
 * 6	超过40000元但是不超过60000元的	30	3375
 * 7	超过60000元但是不超过80000元的	35	6375
 * 8	超过80000元但是不超过100000元的	40	10375
 * 9	超过100000元的	45	15375
 * @Author MinjieZhang
 * @Date 2023-02-27
 */

public class Question22 {
    public static void main(String[] args) {
        System.out.println("请输入工资");
        Scanner sc = new Scanner(System.in);
        //工资salary；税率percent；速算扣除数cut；应纳税额tax；到手工资result
        int salary = sc.nextInt();
        salary -= 2000;
        int percent;
        int cut;
        if (salary <= 500) {
            percent = 5;
            cut = 0;
        } else if (salary <= 2000) {
            percent = 10;
            cut = 25;
        } else if (salary <= 5000) {
            percent = 15;
            cut = 125;
        } else if (salary <= 20000) {
            percent = 20;
            cut = 375;
        } else if (salary <= 40000) {
            percent = 25;
            cut = 1375;
        } else if (salary <= 60000) {
            percent = 30;
            cut = 3375;
        } else if (salary <= 80000) {
            percent = 35;
            cut = 6375;
        } else if (salary <= 100000) {
            percent = 40;
            cut = 10375;
        } else {
            percent = 45;
            cut = 15375;
        }
        double tax;
        tax = salary / 100.0 * percent - cut;
        double result;
        result = salary + 2000 - tax;
        System.out.println("缴纳的个税是：" + tax);
        System.out.println("到手的工资是：" + result);
        sc.close();

    }
}
