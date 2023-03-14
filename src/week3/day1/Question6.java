package week3.day1;

/**
 * 成员内部类，静态内部类的区别实际上时非常明显的，对象的创建和使用都有很大差异。请完成下列题目：
 * 根据注释填写（1），（2），（3）处的代码：
 * 请根据注释,分别对应创建对象的语句
 *
 * @Author MinjieZhang
 * @Date 2023-03-13 20:19
 */
public class Question6 {
    public static void main(String[] args) {
        //(1)创建并初始化Bean1类对象bean1
        Bean1 bean1 = new Question6().new Bean1();
        bean1.i++;
        System.out.println(bean1.i);
        //(2)创建并初始化Bean2类对象bean2
        Bean2 bean2 = new Bean2();
        bean2.j++;
        System.out.println(bean2.j);
        //(3)创建并初始化Bean3类对象bean3
        Bean.Bean3 bean3 = new Bean().new Bean3();
        bean3.k++;
        System.out.println(bean3.k);
    }

    class Bean1 {
        public int i = 0;
    }

    //静态内部类
    static class Bean2 {
        public int j = 0;
    }
}

//成员内部类
class Bean {
    class Bean3 {
        public int k = 0;
    }
}