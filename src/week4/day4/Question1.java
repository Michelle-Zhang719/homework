package week4.day4;

/**
 * 启动2个线程 打印100个数 (使用wait notify) 线程a 打印 1 3 5 7 9 ...奇数 线程b 打印 2 4 6 8 10 ...偶数 分析：线程a打印的是奇数 线程b打印的是偶数 (交替打印)
 * 思路:
 * A线程,先唤醒B线程,然后打印奇数,然后wait自己....
 * B线程,先唤醒A线程,然后打印偶数,然后wait自己...
 * <p>
 * 附加(选做): 怎么保证某个线程先打印, 比如
 * b先打印2
 * a打印1
 * b打印4
 * a打印3.......一直到100
 * <p>
 * 答：执行顺序的问题
 *
 * @Author MinjieZhang
 * @Date 2023-03-23 17:04
 */
public class Question1 {
    //锁对象
    static final Object OBJECT = new Object();

    public static void main(String[] args) {

        //用来打印偶数的线程
        new Thread(() -> {
            synchronized (OBJECT) {
                for (int i = 2; i <= 100; i += 2) {
                    //先唤醒另一个线程
                    OBJECT.notify();
                    System.out.println(Thread.currentThread().getName() + "打印了" + i);
                    //wait 进入阻塞状态，等待另一个线程唤醒
                    try {
                        OBJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                OBJECT.notify();
            }
        }, "Even-线程").start();

        //用来打印奇数的线程
        new Thread(() -> {
            synchronized (OBJECT) {
                for (int i = 1; i <= 100; i += 2) {
                    //先唤醒另一个线程
                    OBJECT.notify();
                    System.out.println(Thread.currentThread().getName() + "打印了" + i);
                    //wait 进入阻塞状态，等待另一个线程唤醒
                    try {
                        OBJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                OBJECT.notify();
            }
        }, "Odd-线程").start();


    }
}