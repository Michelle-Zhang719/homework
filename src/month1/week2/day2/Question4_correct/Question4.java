package month1.week2.day2.Question4_correct;

/**
 * 工具类不需要创建对象，应该私有化构造方法
 * 定义一个Scanner工具类ScannerUtils，提供以下方法：
 *      1，键盘录入字符串
 *      2，键盘录入int整数
 *      3，键盘录入一个Person对象（Person类中有age和name属性）
 * 不要忘记私有化构造器
 * 注：录入对象，无非就是先录入成员变量取值，然后再用构造器创建对象。
 * 这里需要在Scanner对象的基础上,封装一层,完成键盘录入
 * 特别提醒:这个工具类中肯定需要一个Scanner对象用于键盘录入 那么这个变量应该是一个什么变量呢?
 * 工具类的目的是为了方便的调用该方法，然后就能得到想要的结果。
 * 比如键盘录入字符串的这样一个工具方法，只需要调用该方法就能键盘录入得到一个字符串。那么该方法的访问权限，修饰符，返回值类型等都需要如何写呢？思考思考，不行可以讨论讨论，问问老师。
 *
 * 想不出来！
 * @Author MinjieZhang
 * @Date 2023-03-07 21:14
 */
//public class Question4 {
//    ScannerUtils scU = new ScannerUtils();
//    Person p = new Person();
//    scu.inputString();
//}
//
//class ScannerUtils{
//    static Scanner sc;
//
//    {
//        sc = new Scanner(System.in);
//    }
//
//}
//class Person{
//    String age;
//    String name;
//
//    public Person() {
//
//    }
//}
