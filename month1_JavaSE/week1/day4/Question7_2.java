package month1_JavaSE.week1.day4;

import java.util.Scanner;

/**
 * 其次，请尝试完成上课时未完成的人名数组的新增操作。如果有能力，可以继续做完删除，改，查（查出目标元素的下标）。
 * 实现需求
 * 现在给出一个人名数组,一个String数组,String人名数组中存放人的名字,并且不会存储同名
 * 要求实现对这个人名数组的增删改查
 *
 * @Author MinjieZhang
 * @Date 2023-03-02 20:09
 */
public class Question7_2 {
    public static void main(String[] args) {
        String[] names = new String[10];
        // 目前人名数组,String数组,有6个String真实对象,其余四个只有默认值null
        names[0] = "张三";
        names[1] = "李四";
        names[2] = "王五";
        names[3] = "麻子";
        names[4] = "蔡徐坤";
        names[5] = "赵六";
        names[6] = "李华";
        names[7] = "韩梅梅";
        names[8] = "Michelle";
//        names[9] = "路人";
        System.out.print("此数组内有：");
        printRealNames(names);

        System.out.println("请输入新加入的人名：");
        Scanner sc = new Scanner(System.in);
        String newName = sc.nextLine();
        int flag = creat(names, newName);
        switch (flag) {
            case 0:
                System.out.println("此人名 " + newName + " 新增成功！");
                System.out.print("此时数组内有：");
                printRealNames(names);
                break;
            case 1:
                System.out.println("此人名数组已满，不能继续添加！");
                break;
            case 2:
                System.out.println("此人名 " + newName + " 已存在，不可重复添加！");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + flag);
        }


    }

    // 打印人名数组,要求:打印真实的人名,排除数组中的null元素
    public static void printRealNames(String[] names) {
        System.out.print("[");
        for (String name : names) {
            // 排除null元素,跳过
            if (name == null) {
                continue;
            }
            System.out.print(name + ", ");
        }
        System.out.println("\b\b]");
    }


    // 向人名数组中新增一个人名
    /*
        向数组中新增人名,不是要把数组长度+1,这个也叫不到
        而是要把数组中为null的位置利用起来,也就是说新增人名实际上是给null元素赋值的过程
        所以新增人名是这样的:
            找到一个null的位置,然后替换它(赋值)
        分析:
        这个新增人名的方法,有几个执行结果呢?
            1.没有null元素的位置了,说明数组已经装满了,新增失败
            2.新增的人名已经存在了,不允许新增同名,这时新增失败
            3.以上情况都没发生,那就新增成功

       这个方法的返回值类型应该写什么呢?
       像这种方法的执行可能产生多个后果时,推荐返一个状态码,不同的状态码对应不同的结果
       规定:
       返回1时: 表示数组满了,新增失败
       返回2时: 表示插入同名,新增失败
       返回0时: 表示新增成功
       所以返回值类型写int即可

       这个方法的形参列表应该写什么呢?
       首先要想新增元素,被新增元素的数组需要传入方法
       其次还需要传入新增的人名是什么
       需要两个参数
     */
    public static int creat(String[] names, String target) {
        // 大体的思路是:
        // 1.判断人名是否重复,如果重复了,直接插入失败,返回2
        // 思考: 如何判断人名重复呢? 考虑使用equals方法

        // 2.在人名不重复时,考虑插入,这时需要遍历数组,找到一个null的位置,如果找到了,就进行赋值,表示插入成功,返回0
        // 思考: 这里需要对数组中的元素做赋值操作,那么遍历用什么? 不能使用增强for,使用普通for

        // 3.遍历完整个数组,都没有找到null的位置,说明数组满了,插入失败,返回1

        for (String elem : names) {
            //用equals方法前记得判空
            if(elem==null){
                continue;
            }
            if (elem.equals(target)) {
                //人名数组中的名字和目标名字重复
                return 2;
            }

//            if (target.equals(elem)) {
//                //equals方法比较具有对称性！一般把不为空的放在左边
//                //人名数组中的名字和目标名字重复
//                return 2;
//            }
        }

        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                names[i] = target;
                return 0;
            }
        }
        //到这里还没找到null说明数组满了
        return 1;
    }
}
