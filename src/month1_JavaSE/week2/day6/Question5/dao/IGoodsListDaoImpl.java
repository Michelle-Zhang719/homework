package month1_JavaSE.week2.day6.Question5.dao;


import month1_JavaSE.week2.day6.Question5.model.Goods;
import month1_JavaSE.week2.day6.Question5.model.GoodsList;

/**
 * 该层下的GoodsListDao对象
 * 针对的是商品数组
 * 目的是为了对外提供数据处理的操作以及服务
 *
 * @since 10:57
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class IGoodsListDaoImpl implements IGoodsListDao {
    // 提供数据处理,需要直接访问数据源
    private Goods[] srcGoodsArr = GoodsList.GOODS;

    /**
     * 从数据源中读取全部真实商品对象,封装数组返回
     * @return com.cskaoyan.javase.oop3._1interface._4demo.model.Goods[]
     * @author wuguidong@cskaoyan.onaliyun.com
     * @since 11:18
     */
    @Override
    public Goods[] getAllRealGoods() {
        // 1.确定新数组长度,创建新数组
        int count = 0;
        for (Goods goods : srcGoodsArr) {
            if (goods == null) {
                count++;
            }
        }
        int newArrLength = srcGoodsArr.length - count;
        Goods[] result = new Goods[newArrLength];
        // 2.给新数组赋值
        int newIndex = 0;
        for (Goods goods : srcGoodsArr) {
            if (goods == null) {
                continue;
            }
            result[newIndex] = goods;
            newIndex++;
        }
        // 3.返回结果数组
        return result;
    }

    /**
     * 判断id是否重复,如果重复返回true,不重复返回false
     * @param id 被校验的id
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     * @since 11:40
     */
    @Override
    public boolean checkIdExist(int id) {
        /*for (Goods goods : srcGoodsArr) {
            if (goods == null) {
                continue;
            }
            if (goods.getId() == id) {
                return true;
            }
        }*/
        for (Goods realGood : getAllRealGoods()) {
            if (realGood.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * 在id不重复的前提下,插入商品,true表示插入成功,false表示数组满了插入失败
     *
     * @param target 被插入商品的对象
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     * @since 11:40
     */
    @Override
    public boolean createGoods(Goods target) {
        // 找到数据源数组中的一个null元素,给它赋值
        for (int i = 0; i < srcGoodsArr.length; i++) {
            if (srcGoodsArr[i] == null) {
                srcGoodsArr[i] = target;
                // 插入成功
                return true;
            }
        }
        // 没有null的位置,插入失败
        return false;
    }

    /**
     * Description: 在找到id的前提下，找到此id对应的商品信息，并修改
     * @param target 装有要修改的新属性的Goods对象
     * @author: MinjieZhang
     * @date: 2023/3/11 17:04
     */
    @Override
    public void updateGoods(Goods target) {
        // 找到数据源数组中的修改目标元素,给它修改
        for (int i = 0; i < srcGoodsArr.length; i++) {
            if (srcGoodsArr[i].getId() == target.getId()) {
                srcGoodsArr[i].setBrand(target.getBrand()) ;
                srcGoodsArr[i].setName(target.getName());
                srcGoodsArr[i].setPrice(target.getPrice());
                // 修改成功
            }
        }
    }

    /**
     * Description: 在找到id的前提下，找到此id对应的商品信息，并以字符串的形式返回
     * @param findId 要查询商品的id
     * @return java.lang.String
     * @author: MinjieZhang
     * @date: 2023/3/11 17:06
     */
    @Override
    public String findGoods(int findId) {
        //要返回的商品信息字符串
        String info = null;
        for (int i = 0; i < srcGoodsArr.length; i++) {
            if (srcGoodsArr[i].getId() == findId) {
                info = "商品id为"+findId+"的商品名为："+srcGoodsArr[i].getName()+", 价格为："+srcGoodsArr[i].getPrice()+"，品牌为："+srcGoodsArr[i].getBrand();
                break;// 查询成功
            }
        }
        return info;
    }
}
