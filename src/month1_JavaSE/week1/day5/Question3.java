package month1_JavaSE.week1.day5;

/**
 * 对于任意两个字符串对象的引用str1，str2。
 * 怎么判断这两个字符串对象的内容相同呢？
 * 注：如果有一个引用等于null，那么另一个引用也等于null，也可算内容相同
 *
 * @Author MinjieZhang
 * @Date 2023-03-03 18:59
 */
public class Question3 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";
        judgeStrSame(str1, str2);
    }


    public static void judgeStrSame(String str1, String str2) {
        /*
        思路：
        先判断str1和str2是否同时为null，若为null，则相同
        在其中一个为null的时候，字符串不同
        在都不为null的情况下，判断内容是否完全相同
         */
        //记录字符串为null的个数
        int count = 0;
        if (str1 == null) {
            count++;
        }
        if (str2 == null) {
            count++;
        }
        switch (count) {
            case 0:
                if (str1.equals(str2)) {
                    System.out.println("两字符串不为null，且内容相同，内容为：" + str1);
                } else {
                    System.out.println("两字符串有内容，但不相同，分别为： str1 = " + str1 + " str2 = " + str2);
                }
                break;
            case 1:
                System.out.println("两字符串中，有一个为null，故不同");
                break;
            case 2:
                System.out.println("两字符串相同，且都为null");
                break;
        }
    }
}
