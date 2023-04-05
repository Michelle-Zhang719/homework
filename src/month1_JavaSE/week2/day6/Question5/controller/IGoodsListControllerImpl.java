package month1_JavaSE.week2.day6.Question5.controller;


import month1_JavaSE.week2.day6.Question5.dao.IGoodsListDao;
import month1_JavaSE.week2.day6.Question5.dao.IGoodsListDaoImpl;
import month1_JavaSE.week2.day6.Question5.model.Goods;

/**
 * 该层下的GoodsListController对象
 * 针对的是商品数组
 * 目的是为了对外提供业务逻辑处理的操作以及服务
 *
 * @since 10:56
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class IGoodsListControllerImpl implements IGoodsListController {
    // 实现业务逻辑处理需要依赖于Dao层对象
    /*
        为了体现接口制定标准的规范性
        禁止实现类跨过接口对外提供服务
        所以使用父接口引用,限制访问范围仅在父接口本身
     */
    private IGoodsListDao igd = new IGoodsListDaoImpl();

    /**
     * 从数据源中读取全部真实商品对象,封装数组返回
     * @return com.cskaoyan.javase.oop3._1interface._4demo.model.Goods[]
     * @author wuguidong@cskaoyan.onaliyun.com
     * @since 11:14
     */
    @Override
    public Goods[] showAllRealGoods() {
        // 该层下的对象,仅对外提供业务逻辑处理,不做任何数据处理
        // 数据处理依赖于dao层对象
        return igd.getAllRealGoods();
    }

    /**
     * 新增一条商品记录
     * id重复,新增失败 返回1
     * 数组没有null的位置,满了,新增失败 返回2
     * 没有上述两种情况,插入成功! 返回0
     *
     * @param id 新增商品的id
     * @param name 新增商品的名称
     * @param price 新增商品的价格
     * @param brand 新增商品的品牌
     * @return int
     * @author wuguidong@cskaoyan.onaliyun.com
     * @since 11:32
     */
    @Override
    public int createGoods(int id, String name, double price, String brand) {
        // 依赖于dao层对象,判断id是否重复,如果重复返回true,不重复返回false
        if (igd.checkIdExist(id)) {
            return 1;
        }
        // 代码运行到这里,说明id肯定不重复,于是开始考虑插入操作
        // 这时的插入操作只有两种可能性,成功了,失败了,失败的原因是数组满了
        // true表示插入成功,false表示数组满了插入失败
        Goods target = new Goods(id, name, price, brand);
        if (igd.createGoods(target)) {
            return 0;
        }
        // 代码运行到这里,插入失败,数组满了
        return 2;
    }

    /**
     * Description: 修改一条商品记录， id没找到，修改失败 返回0  id找到，修改成功  返回1
     * @param updateId 修改商品id，id不可修改
     * @param updateName 修改商品的名字
     * @param updatePrice 修改商品的价格
     * @param updateBrand 修改商品的品牌
     * @return int
     * @author: MinjieZhang
     * @date: 2023/3/11 16:36
     */
    @Override
    public int updateGoods(int updateId, String updateName, double updatePrice, String updateBrand) {
        // 依赖于dao层对象,判断id是否重复,如果重复返回true, 当id不重复时，代表没有找到id，修改失败
        if ( !igd.checkIdExist(updateId)) {
            return 0;
        }
        // 代码运行到这里,说明id肯定不重复,于是开始考虑修改操作，
        Goods target = new Goods(updateId, updateName, updatePrice, updateBrand);
        igd.updateGoods(target);
        //修改成功，返回1
        return 1;
    }

    /**
     * Description: 根据商品id查询商品记录，返回查询到的商品name,price,brand信息字符串
     * @param findId 要查询的商品id
     * @return java.lang.String
     * @author: MinjieZhang
     * @date: 2023/3/11 16:58
     */
    @Override
    public String findGoods(int findId) {
        // 依赖于dao层对象,判断id是否重复,如果重复返回true, 当id不重复时，代表没有找到id，查询失败
        if ( !igd.checkIdExist(findId)) {
            return "此id不存在";
        }
        // 代码运行到这里,说明id肯定不重复,于是开始考虑查询操作，
        //查找成功，返回字符串
        return igd.findGoods(findId);
    }
}
