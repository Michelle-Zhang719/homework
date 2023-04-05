package month1_JavaSE.week2.day2.Question4_correct;

import java.util.Scanner;

/**
 * 键盘录入工具类
 * Scanner在做键盘录入时,建议不要混用next系列和nextLine方法
 * 否者会出现问题
 * 工具类当中的Scanner实际上没有必要创建多个对象,全局使用一个对象就行了
 * 所以给出一个静态成员变量sc
 *
 * @Author MinjieZhang
 * @Date 2023-03-07 22:53
 */

public class ScannerTools {
    /*
        该工具类中全局使用一个Scanner对象足矣
        没有必要每一个方法创建一个对象
        创建对象是耗费性能
     */
    private static Scanner sc = new Scanner(System.in);

    // 工具类无需在外部创建对象，应该私有化它
    private ScannerTools() {
    }

    public static String getStringByScanner() {
        System.out.println("请输入字符串：");
        return sc.nextLine();
    }

    public static int getIntByScanner() {
        System.out.println("请输入一个int整数：");
        return Integer.parseInt(sc.nextLine());
    }

    // 工具类接收对象，先接收各个成员变量的取值，最后使用构造方法创建对象即可
    public static Person getPersonInstanceByScanner() {
        System.out.println("现在开始键盘录入一个Person对象！");
        System.out.println("请输入Person对象的name：");
        String name = sc.nextLine();
        System.out.println("请输入Person对象的age：");
        int age = Integer.parseInt(sc.nextLine());
        Person p = new Person(name, age);
        System.out.println("Person对象创建完毕！");
        return p;
    }

    // 录入数组，录入对象和上述方法是一样的，所以直接调用即可
    public static Person[] getPersonArrByScanner(int length) {
        Person[] targetArr = new Person[length];
        System.out.println("现在开始为Person数组输入Person对象！");
        System.out.println("你总共需要输入" + length + "个Person对象！");
        for (int i = 0; i < targetArr.length; i++) {
            System.out.println("现在是输入第" + (i + 1) + "个Person对象！");
            targetArr[i] = getPersonInstanceByScanner();
        }
        System.out.println("Person数组输入完毕！");
        return targetArr;
    }

    public static void closeScanner() {
        sc.close();
    }
}