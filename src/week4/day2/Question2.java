package week4.day2;

/**
 * 有3个线程,T1,T2,T3, 请确保: T1线程先执行，T2在T1之后执行,T3在T2执行完后执行
 * 提示: 利用线程控制API
 * 答：使用join方法，其作用是等待该线程终止
 *
 * @Author MinjieZhang
 * @Date 2023-03-21 19:05
 */

public class Question2 {
    public static void main(String[] args) throws InterruptedException {

        RunnableImpl task = new RunnableImpl();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
}

class RunnableImpl implements Runnable {
    static int count = 0;

    @Override
    public void run() {
        System.out.println("执行的次数为：" + count);
        count++;
    }
}
