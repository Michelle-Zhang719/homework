package month1_JavaSE.week4.day3;

import java.io.*;

/**
 * @Description 在Question1的基础上，真的实现文件复制
 * @Author MinjieZhang
 * @Date 2023-03-22 20:35
 */
public class Question1_correct {
    public static void main(String[] args) throws FileNotFoundException {
        File sourceFile = new File("src/month1_JavaSE.week4/day3/第1题结果.png");
        File targetFile = new File("src/month1_JavaSE.week4/第1题结果.png");
        DownloadThread downloadThread = new DownloadThread(sourceFile, targetFile);
        Thread thread1 = new Thread(downloadThread);
        thread1.start();
        Thread thread2 = new Thread(downloadThread);
        thread2.start();
        Thread thread3 = new Thread(downloadThread);
        thread3.start();
    }
}


class DownloadThread implements Runnable {
    private int surplusYield;
    private File sourceFile;
    private File targetFile;
    //对象锁
    private static final Object LOCK = new Object();

    private BufferedInputStream in;
    private BufferedOutputStream out;


    //构造器，用来传参
    public DownloadThread(File sourceFile, File targetFile) throws FileNotFoundException {
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
        surplusYield = (int) sourceFile.length();
        in = new BufferedInputStream(new FileInputStream(sourceFile));
        out = new BufferedOutputStream(new FileOutputStream(targetFile));
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (LOCK) {
                    byte[] bytes = new byte[5 * 1024];
                    int readCount;
                    if (surplusYield > 0) {

                        readCount = in.read(bytes);
                        out.write(bytes, 0, readCount);
                        surplusYield -= readCount;
                        System.out.println(Thread.currentThread().getName() + "复制了" + readCount + "字节，剩余资源量" + surplusYield);

                    } else {
                        return;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}