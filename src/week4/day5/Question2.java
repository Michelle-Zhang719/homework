package week4.day5;

/**
 * 要求2个线程交替打印1A2B3C4D
 * wait notify
 * 附加: 怎么保证某个线程先执行 比如先打印A 再打印1
 *
 * @Author MinjieZhang
 * @Date 2023-03-24 21:43
 */
public class Question2 {
    //锁对象
    static final Object OBJECT = new Object();

    public static void main(String[] args) {
        //用来打印奇数的线程
        new Thread(() -> {
            synchronized (OBJECT) {
                char c = 'A';
                for (int i = 1; i < 5; i++) {
                    //先唤醒另一个线程
                    OBJECT.notify();

                    System.out.println(Thread.currentThread().getName() + "打印了" + c);
                    c++;
                    //wait 进入阻塞状态，等待另一个线程唤醒
                    try {
                        OBJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                OBJECT.notify();
            }
        }, "letter-线程").start();


        //用来打印偶数的线程
        new Thread(() -> {
            synchronized (OBJECT) {
                for (int i = 1; i < 5; i++) {
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
        }, "num-线程").start();


    }
}
