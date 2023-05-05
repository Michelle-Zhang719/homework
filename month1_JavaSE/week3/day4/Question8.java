package month1_JavaSE.week3.day4;

import java.util.Scanner;

/**
 * 异常类只是描述异常的信息，但是什么时候产生异常，怎么处理异常和异常类本身没有关系
 * 分别自定义编译时异常和运行时异常，在方法中抛出异常，main方法中调用该方法，并处理相应的异常
 *
 * @Author MinjieZhang
 * @Date 2023-03-16 22:05
 */

public class Question8 {
    public static void main(String[] args) {
        try {
            func();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }


    private static void func() throws MyException {
        // 输入一个分数
        System.out.println("请输入一个分数:");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        // 判断一下是否合法
        if (i < 0 || i > 100) {
            // 不合法 抛出异常
            // 抛出运行时异常
             throw new MyRuntimeException("运行时异常：分数不合法");
            // 抛出编译时异常
            //throw new MyException("编译时异常：分数不合法");
        }
    }
}


// 定义编译时异常 继承Exception，就表示自定义了一个编译时异常
class MyException extends Exception{
    public MyException() {
    }


    public MyException(String message) {
        super(message);
    }
}


// 定义运行时异常 继承RuntimeException，就表示自定义了一个运行时异常
class MyRuntimeException extends RuntimeException{
    public MyRuntimeException() {
    }


    public MyRuntimeException(String message) {
        super(message);
    }
}