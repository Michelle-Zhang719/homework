package month1_JavaSE.week1.day6;

/**
 * 二维数组题目
 * 题目1
 * 某公司该年度，每个季度的销售额（单位：万元）
 * 如下：
 * 第一季度：30,66, 48
 * 第二季度：10, 33, 20
 * 第三季度: 10,99,103
 * 第四季度: 9,18,27
 * 请使用二维数组存储数据 并计算： 1，每个季度平均销售额 2，年度销售总额
 *
 * @Author MinjieZhang
 * @Date 2023-03-04 16:23
 */
public class Question2_1 {
    public static void main(String[] args) {
        int[][] sale = {{30, 66, 48}, {10, 33, 20}, {10, 99, 103}, {9, 18, 27}};

        int yearSum = 0;
        for (int i = 0; i < sale.length; i++) {
            //循环四次，一维数组的个数
            double averSeasonSale = 0;
            int seasonSum = 0;
            for (int j = 0; j < sale[i].length; j++) {
                //一维数组
                seasonSum += sale[i][j];
                yearSum += sale[i][j];
            }
            averSeasonSale = seasonSum / 3.0;
            System.out.println("第" + i + "季度平均销售额为：" + averSeasonSale);
        }
        System.out.println("年度销售总额为：" + yearSum);
    }
}
