package month1_JavaSE.week2.day6.Question5.dao;

import month1_JavaSE.week2.day6.Question5.model.Goods;

/**
 * 该接口表示对商品数组做数据处理操作的标准和规范
 *
 * @since 11:01
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public interface IGoodsListDao {
    // 根据数据源数组封装新的数组,仅装有真实商品对象
    Goods[] getAllRealGoods();

    // 判断id是否重复,如果重复返回true,不重复返回false
    boolean checkIdExist(int id);

    // 在id不重复的前提下,插入商品,true表示插入成功,false表示数组满了插入失败
    boolean createGoods(Goods target);

    //在id找到的前提下,修改商品
    void updateGoods(Goods target);

    //在id找到的前提下,查询此id商品的信息
    String findGoods(int findId);
}
