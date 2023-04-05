package month1_JavaSE.week2.day3;

import java.util.Scanner;

/**
 * 当属性私有化，又有外界访问需求时，提供Getter/Setter方法
 * 创建两个类，分别用来表示长方形和正方形。
 * 同时定义所需的成员变量（边长），代表长方形或者正方形的边长
 * （私有化成员变量，并提供相应的Getter/Setter方法，获取以及改变长方形和正方形的边长。）
 * 然后在两个类中分别定义两个成员方法，用于求对应图形的面积和周长。
 * 最后，写代码测试一下创建对象，方法调用等。
 * 注：Getter/Setter方法可以选择手写一个，其余的用快捷键自动生成。
 * <p>
 * 该题是纯粹语法练习，不要浪费时间。
 *
 * @Author MinjieZhang
 * @Date 2023-03-08 14:16
 */
public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //长方形
        rectangle re = new rectangle();
        System.out.println("请输入长方形的长：");
        re.setLength(sc.nextInt());
        System.out.println("请输入长方形的宽：");
        re.setWidth(sc.nextInt());
        System.out.println("长方形的面积为：" + re.getArea() + " 周长为：" + re.getPerimeter());

        //正方形
        Square sq = new Square();
        System.out.println("请输入正方形的边长：");
        sq.setSideLen(sc.nextInt());
        System.out.println("正方形的面积为：" + sq.getArea() + " 周长为：" + sq.getPerimeter());
    }
}

//长方形
class rectangle {
    private int length;
    private int width;

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }
}

//正方形
class Square {
    private int sideLen;

    public void setSideLen(int sideLen) {
        this.sideLen = sideLen;
    }

    public int getArea() {
        return sideLen * sideLen;
    }

    public int getPerimeter() {
        return 4 * sideLen;
    }
}