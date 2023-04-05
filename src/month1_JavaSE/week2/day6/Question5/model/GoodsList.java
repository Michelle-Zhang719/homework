package month1_JavaSE.week2.day6.Question5.model;

/**
 * 商品对象容器,模拟一下数据库
 *
 * @since 10:19
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class GoodsList {
    public static final Goods[] GOODS = new Goods[7];

    static {
        GOODS[0] = new Goods(1, "iPhone12", 5000, "苹果");
        GOODS[1] = new Goods(2, "联想笔记本", 6000, "联想");
        GOODS[2] = new Goods(3, "iPhone13", 7000, "苹果");
        GOODS[3] = new Goods(4, "iPhone14", 8000, "苹果");
        GOODS[4] = new Goods(5, "iPhone15", 9000, "苹果");
        GOODS[5] = new Goods(6, "iPhone16", 10000, "苹果");
    }
}
