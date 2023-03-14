package week3.day2;

/**
 * equals方法语法编程练习题
 * 定义一个Animal类
 * 成员变量：
 * int age,String name,double price
 * 手写它的equals方法，比较getClass和instanceof的区别
 * <p>
 * 答：
 * 1.getClass判断,利用Class对象唯一的特点进行判断
 * 选择这种排它性校验,是非常严格的
 * 必须是同种数据类型才可以继续比较
 * 这种方式不接收子类对象的传参,很严格
 * <p>
 * 2.(更宽松一点)
 * 用instanceof关键字
 * 引用 instanceof 类名/接口名
 * 判断引用指向的对象是否是后面类名的对象或者子类对象
 * 当然如果后面写的是抽象类或者接口,那么必然判断是否是子类对象
 * 如果是就返回true，不是就返回false
 * 所以instanceof在做排它性校验时,允许传入子类对象
 *
 * @Author MinjieZhang
 * @Date 2023-03-14 21:53
 */
public class Question6 {
    public static void main(String[] args) {
        Animal a1 = new Animal(18, "pig", 100);
        Animal a2 = new Animal(18, "pig", 100);
        System.out.println(a1.equals(a2));
        AnimalSon as = new AnimalSon(18, "pig", 100);
        System.out.println(as.equals(a1));

    }
}

class Animal {
    int age;
    String name;
    double price;

    public Animal(int age, String name, double price) {
        this.age = age;
        this.name = name;
        this.price = price;
    }

    //重写equals方法
    @Override
    public boolean equals(Object obj) {
        // 1.满足自反性
        if (this == obj) {
            return true;
        }
        // 2.满足排它性 getclass方法
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
//        //instanceof
//        if (!(obj instanceof Animal)) {
//            return false;
//        }
        // 对称性,传递性,一致性,只需要通过比较对象成员变量的数值大小来判断对象相等
        // 代码运行到这里,obj引用指向的对象一定是Student对象,无需再判断,可以直接强转
        Animal target = (Animal) obj;
        /*if (target.age == age && target.score == score){
            return true;
        }
        return false;*/
        if (target.age != age) {
            return false;
        }
        if (target.name != name) {
            return false;
        }
        // 代码运行到这里,age一定相等的,所以score的比较结果就是对象相等的比较结果
        return price == target.price;
    }

}

class AnimalSon extends Animal {

    public AnimalSon(int age, String name, double price) {
        super(age, name, price);
    }
}