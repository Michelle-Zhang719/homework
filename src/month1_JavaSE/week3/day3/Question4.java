package month1_JavaSE.week3.day3;

/**
 * 思考true false 的原因
 *
 * 答：
 * 语句：   String s1 = "Java";
 * 在堆中创建字符串对象“Java”是拘留字符串对象将字符串对象”Java“的引用保存在字符串常量池中
 * 语句：   String s2 = s1.intern();
 * 直接返回字符串常量池中字符串对象”Java“对应的引用
 * 语句：   String s3 = new String("Java");
 * 会在堆中在单独创建一个字符串对象，是非拘留字符串对象
 * 语句：   String s4 = s3.intern();
 * 判断已有相同内容的拘留字符串存在直接返回字符串常量池中字符串对象”Java“对应的引用
 * s1 和 s2 指向的是堆中的同一个对象，故返回true
 * s3是非拘留字符串对象，肯定和s1 ，s2 ，s4不同
 * s4判断已有相同内容的拘留字符串Java存在，返回引用，和s1 ，s2相同
 * @Author MinjieZhang
 * @Date 2023-03-15 19:51
 */

public class Question4 {
    public static void main(String[] args) {
        // 在堆中创建字符串对象”Java“
        // 将字符串对象”Java“的引用保存在字符串常量池中
        String s1 = "Java";
        // 直接返回字符串常量池中字符串对象”Java“对应的引用
        String s2 = s1.intern();
        // 会在堆中在单独创建一个字符串对象
        String s3 = new String("Java");
        // 直接返回字符串常量池中字符串对象”Java“对应的引用
        String s4 = s3.intern();
        // s1 和 s2 指向的是堆中的同一个对象



        System.out.println(s1 == s2); // true
        // s3 和 s4 指向的是堆中不同的对象
        System.out.println(s3 == s4); // false
        // s1 和 s4 指向的是堆中的同一个对象
        System.out.println(s1 == s4); //true
    }
}