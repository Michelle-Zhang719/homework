package week4.day4;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个任务，它将睡眠随机1-10s， 然后显示睡眠时间并退出。创建并运行一定数量的这个任务
 * ps:利用线程池
 *
 * @Author MinjieZhang
 * @Date 2023-03-23 17:25
 */
public class Question2 {
    public static void main(String[] args) {

        //创建一个线程池,里面有两个线程对象
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            exec.submit(new SleepThread());
        }
        exec.shutdown();
    }


}

class SleepThread implements Runnable {

    @Override
    public void run() {
        //随机睡眠时间
        int num = (int) (Math.random() * 11);
        System.out.println(Thread.currentThread().getName() + "睡眠时间：" + num);
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
