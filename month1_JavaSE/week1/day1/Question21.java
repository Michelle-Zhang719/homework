package month1_JavaSE.week1.day1;
import java.util.Scanner;

/**
 * @Description 先键盘录入一个表示月份的整数，然后利用switch语句输出每个月份对应的季节：
 * 12、1、2：冬季  3、4、5：春季  6、7、8：夏季  9、10、11：秋季
 * @Author MinjieZhang
 * @Date 2023-02-27
 */
public class Question21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入1-12：");
        int day = sc.nextInt();
        switch (day) {
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("输入错误！");
                break;
        }
    }
}
