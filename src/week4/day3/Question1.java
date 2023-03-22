package week4.day3;

import java.io.File;
import java.io.ObjectOutput;

/**
 * 用多线程代码来模拟，迅雷用3个线程下载100M资源的的过程。
 * 每个线程每次执行都下载1兆(M)资源，直到下载完毕，即剩余的待下载资源大小为0
 * (用一个整数表示剩余资源量，一个线程每次执行会下载1兆(M), 下载完毕后该线程会打印剩余需要下载的资源)
 * 参考售票的代码实现，这里需要考虑多线程的数据安全问题
 * 注：仅模拟下载的过程，不是真的下载，也不是真的复制文件！
 *
 * @Author MinjieZhang
 * @Date 2023-03-22 20:11
 */
public class Question1 {
    public static void main(String[] args) {
        DownloadResource taskDownload = new DownloadResource();
        Thread t1 = new Thread(taskDownload, "线程1");
        t1.start();
        Thread t2 = new Thread(taskDownload, "线程2");
        t2.start();
        Thread t3 = new Thread(taskDownload, "线程3");
        t3.start();
    }

}

class DownloadResource implements Runnable {
    //表示剩余资源量  从100开始
    private int resourceSize = 100;
    //创建锁对象
    private static final Object Lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (Lock) {
                //此大括号内为原子操作
                if (resourceSize > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    resourceSize--;
                    System.out.println(Thread.currentThread().getName() + ":还需要下载" + resourceSize + "M");
                } else {
                    System.out.println("下载完成");
                    return;
                }
            }
        }
    }
}
