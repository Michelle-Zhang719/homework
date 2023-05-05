package month2.week5.day4;

import java.util.ArrayList;
import java.util.Random;

/**
 * 生成一个双色球中奖号码存储到ArrayList中
 * 双色球:
 * 前6个红球，只能是01-33之间的号，并且六个号码不能重复
 * 后1个蓝球，只能是01-12之间的号。
 *
 * @Author MinjieZhang
 * @Date 2023-04-06 9:22
 */
public class Question3 {
    public static void main(String[] args) {
        //生成一个[1,34)之间的随机数

        ArrayList<StringBuilder> numList = new ArrayList<>();
        while (numList.size()<6){
            //6个红色球
            int num1 = 33;
            //得到一个随机数
            StringBuilder sb = getRandomNum(num1);
            if (numList.size()==0){
                //第一个球
                numList.add(sb);
                continue;
            }
            if (!numList.contains(sb)){
                numList.add(sb);
            }
        }
        //一个蓝色球
        int num2 = 12;
        //得到一个随机数
        StringBuilder sb = getRandomNum(12);
        if (!numList.contains(sb)){
            numList.add(sb);
        }
        System.out.println(numList);

    }

    private static StringBuilder getRandomNum(int range) {
        int num =  new Random().nextInt(range) + 1 ;
        StringBuilder sb = new StringBuilder();
        if (num<10){
            //num 在 [1-9] 换为 01--09
            sb.append("0");
            sb.append(num);
        }else{
            sb.append(num);
        }
        return sb;
    }
}
