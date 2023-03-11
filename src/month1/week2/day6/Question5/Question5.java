package month1.week2.day6.Question5;


import month1.week2.day6.Question5.controller.IGoodsListController;
import month1.week2.day6.Question5.controller.IGoodsListControllerImpl;
import month1.week2.day6.Question5.model.Goods;

/**
 * 某电商系统后台，前端程序员需要后端程序员，提供接口来完成库存的管理，展示页面。
 * 假如前后端商量好，要求：
 * 1.展示全部商品（goods）页面时，将仅装有商品对象的数组返回，前端不提供任何数据。
 * 2.新增商品时，前端提供商品各种参数，后端需要校验ID唯一性，然后将对象插入数组，返回插入结果。
 * 3.删除商品时，前端提供商品ID，后端将该商品删除后，返回删除删除结果。
 * （成功返回true，找不到该ID的商品返回false）
 *
 * Git拉取老师上课讲的商品对象数组分层增删改查的代码
 * 尝试完成剩下的修改 查询功能
 * 4.修改: 前端提供一个目标id,以及修改的后的name,price,brand(id不允许修改)
 * 5.查询: 前端提供一个商品id,返回查询到的商品name,price,brand信息(可以返回一个装有商品信息的字符串做返回值)
 *
 * @author wuguidong@cskaoyan.onaliyun.com
 * @since 10:16
 */
public class Question5 {
    // 对外提供业务操作的对象是controller层对象,所以创建它的对象,来支撑这个业务操作
    // ic对象对外提供展示商品的操作方法
    private static IGoodsListController ic = new IGoodsListControllerImpl();

    public static void main(String[] args) {
        // 1.模拟一下前端,向后端发送请求,要开始进行展示商品的操作

        // 这时可以先假设方法已存在,假设对象已经有这个行为
        Goods[] realGoodsArr = ic.showAllRealGoods();
        showAllRealGoods(realGoodsArr);

        // 2.模拟一下前端,向后端发送请求,要开始进行新增商品的操作
        int id = 100;
        String name = "iPhone17";
        double price = 11000;
        String brand = "苹果";
        /*
            分析下这个方法,执行的结果有几种?
                1.id重复,新增失败
                2.数组没有null的位置,满了,新增失败
                3.没有上述两种情况,插入成功!
            根据不同结果,给出不同的返回值:
                id重复,新增失败 返回1
                数组没有null的位置,满了,新增失败 返回2
                没有上述两种情况,插入成功! 返回0
         */
        switch (ic.createGoods(id, name, price, brand)) {
            case 0:
                System.out.println("插入成功了!");
                showAllRealGoods(ic.showAllRealGoods());
                break;
            case 1:
                System.out.println("id重复,新增失败!");
                break;
            case 2:
                System.out.println("数组没有null的位置,满了,新增失败!");
                break;
        }

        //4.修改: 前端提供一个目标id,以及修改的后的name,price,brand(id不允许修改)
        int updateId = 3;
        String updateName = "华为p50";
        double updatePrice = 7000;
        String updateBrand = "华为";

        /*
        思路：
        id没找到，修改失败 返回0
        id找到，修改成功  返回1
         */
        switch (ic.updateGoods(updateId,updateName,updatePrice,updateBrand)){
            case 0:
                System.out.println("此id不存在");
                break;
            case 1:
                System.out.println("id为"+updateId+"的商品信息修改成功");
                showAllRealGoods(ic.showAllRealGoods());
                break;
        }

        //5.查询: 前端提供一个商品id,返回查询到的商品name,price,brand信息(可以返回一个装有商品信息的字符串做返回值)
        int findId = 4;

        /*
        思路：
        id没找到，查询失败 返回提示信息
        id找到，查询成功 返回装有商品信息的字符串
         */
        System.out.println(ic.findGoods(findId));
    }

    private static void showAllRealGoods(Goods[] realGoodsArr) {
        System.out.println("目前所有存在的商品信息如下:");
        for (Goods real : realGoodsArr) {
            real.printGoods();
        }
    }
}
