package month1.week2.day6.Question5.controller;

import month1.week2.day6.Question5.model.Goods;

/**
 * 该接口表示对商品数组做业务逻辑处理操作的标准和规范
 *
 * @since 11:01
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public interface IGoodsListController {
    // 从数据源中读取全部真实商品对象,封装数组返回
    Goods[] showAllRealGoods();

    // 新增一条商品的记录
    int createGoods(int id, String name, double price, String brand);

    //修改一条商品的记录
    int updateGoods(int updateId, String updateName, double updatePrice, String updateBrand);

    //查询一条商品记录
    String findGoods(int findId);
}
