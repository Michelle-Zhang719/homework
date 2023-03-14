package week2.day6.Question5.model;

/**
 * 商品实体类
 *
 * @since 10:17
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Goods {
    private int id;
    private String name;
    private double price;
    private String brand;

    public Goods(int id, String name, double price, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    // 打印商品的方法
    public void printGoods() {
        System.out.println("编号为" + id + "的商品,其商品名为" + name + ", 它的品牌是" + brand + ", 它的价格是" + price);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
