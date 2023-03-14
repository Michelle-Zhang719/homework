package week1.day3;

import org.junit.Test;

import java.util.Scanner;

/**
 * 1.练习使用Junit，按照上课时候讲的步骤逐步操作即可。顺便试一试在Junit中使用Scanner键盘录入。
 * 注：一般情况下，Junit下是不能使用Scanner的，感兴趣可以尝试百度解决一下。
 * 答：
 * 使用scanner输入和I/O流。尝试过的朋友相信都知道，单元测试中使用scanner输入和I/O流是没有任何反应的。
 * 不是你写得代码有问题哈，不要怀疑自己。网上这方面有很多解决方案，个人觉得最偷懒的方法：
 * A. 通过IDEA工具Help-Edit Custom VM Options打开配置文件位置
 * B. 修改配置文件idea64.exe.vmoptions，在最后一行添加：-Deditable.java.test.console=true
 * C. 重启IDEA【必须重启哈】
 * <p>
 * 2.理解全限定类名，尝试使用IDEA直接复制全限定类名。
 * 右键@Test-----copy reference------paste as plain text
 *
 * @Author MinjieZhang
 * @Date 2023-03-01 14:59
 */
public class Question3 {

    //1.@Test---Alt+回车------写方法即可
    @Test
    public void test1() {
        //方法体
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个int类型的数：");
        int num1 = sc.nextInt();
        System.out.println(num1);
    }

    //2.理解全限定类名，尝试使用IDEA直接复制全限定类名。
    @Test
    public void test2() {
        //org.junit.Test;  此为全限定类名2
    }
}
