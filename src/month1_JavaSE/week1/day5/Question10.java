package month1_JavaSE.week1.day5;

/**
 * 设计物品（Item）类
 * 它具有以下属性：
 * 1. 名字
 * 2. 价格
 * 3. 类别
 * <p>
 * 它具有以下行为：
 * 1. 售卖。该方法需要传入一个参数表示购买使用的金钱，如果金钱足够则打印"xx物品被卖出"的信息，并将找零作为返回值。
 * 否则打印"金钱不足，购买失败"，并将"-1"作为返回值表示购买失败。
 * <p>
 * 类定义完毕后，试着创建三个对象并使用"对象名点"完成属性赋值：
 * 1. "手机类的Samsung Galaxy S21 8000元"
 * 2. "家具类的海尔冰箱 3000元"
 * 3. "日用品类的海飞丝洗发水 30元"
 * 然后自行调用一下售卖方法，测试一下。
 * 注：
 * 建议用一个public class作为测试类，用于创建对象，调用方法，访问属性等。
 * 具体类（比如本题中的Item）的定义，建议在public class下面定义非public class，这样比较方便快捷。
 * 不要将类定义在其它类的内部（内部类），在定义class时，一定要看清楚大括号！
 * 以上三条，（如无特别要求）适用于后续面向对象学习中的所有习题。
 *
 * @Author MinjieZhang
 * @Date 2023-03-03 20:04
 */
public class Question10 {
    public static void main(String[] args) {
        Item phone = new Item();
        phone.name = "Samsung Galaxy S21";
        phone.price = 8000;
        phone.type = "手机类";
        phone.sale(2000);

        Item refrigerator = new Item();
        refrigerator.name = "海尔冰箱";
        refrigerator.price = 3000;
        refrigerator.type = "家具类";
        refrigerator.sale(3400);

        Item shampoo = new Item();
        shampoo.name = "海飞丝洗发水";
        shampoo.price = 30;
        shampoo.type = "日用品类";
        shampoo.sale(30);
    }
}

class Item {
    //物品名字
    String name;
    //物品价格
    double price;
    //物品类别
    String type;

    public double sale(double needPrice) {
        //找零
        double change = needPrice - price;
        if (change >= 0) {
            System.out.println(name + "物品被卖出");
            return change;
        } else {
            System.out.println("金钱不足，购买" + name + "失败");
            return -1;
        }
    }
}
