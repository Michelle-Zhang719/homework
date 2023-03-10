package month1.week2.day4.Question11;

/**
 * @Description 读程序题
 * @Author MinjieZhang
 * @Date 2023-03-09 20:24
 */
public class Question11 {
    public static void main(String[] args) {
        Son s = new Son();
        // 0  20方法重写
        System.out.println(s.num);
        System.out.println();


        //对象名.成员变量  看引用
        // 0  10
        Father fs = new Son();
        System.out.println(fs.num);
        // Father f = new Father();
        System.out.println();


        //有参构造  0 30
        Son s2 = new Son(30);
        System.out.println(s2.num);
        System.out.println();

        //0 10
        Father fs2 = new Son(30);
        System.out.println(fs2.num);
        System.out.println();
    }
}

class Father {
    int num = 10;
    public int getNum() {
        return num;
    }
    //构造器
    public Father() {
        System.out.println(getNum());
    }
}
class Son extends Father {
    int num = 20;
    @Override
    public int getNum() {
        return num;
    }

    //无参构造
    public Son() {
        // super();
    }
    //单参构造 也有super（）；
    public Son(int num) {
        this.num = num;
    }
}