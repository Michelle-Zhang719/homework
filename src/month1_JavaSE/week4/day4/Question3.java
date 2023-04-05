package month1_JavaSE.week4.day4;

import java.io.*;
import java.util.concurrent.*;

/**
 * 多线程实现方式三:
 * 使用Callable的方式去实现之前的多线程文件复制,
 * 要求Callable任务的返回值为新文件的地址, 接收该地址,并且保存到文件path.txt里面
 *
 * @Author MinjieZhang
 * @Date 2023-03-23 19:16
 */
public class Question3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        //创建FutureTask对象
        FutureTask<String> result = new FutureTask<>(new CopyFile());
        //用三个线程复制
        Thread t1 = new Thread(result);
        t1.start();
        Thread t2 = new Thread(result);
        t2.start();
        Thread t3 = new Thread(result);
        t3.start();

        //得到返回值后，写入path文件中
        String resultStr = result.get();
        FileOutputStream out = new FileOutputStream("src/month1_JavaSE.week4/day4/path.txt");
        out.write(resultStr.getBytes());

    }

}

class CopyFile implements Callable<String> {
    File sourceFile = new File("src/month1_JavaSE.week4/day4/第1题结果.png");
    File targetFile = new File("src/month1_JavaSE.week4/第1题结果.png");
    private int fileSize = (int) sourceFile.length();
    private static final Object LOCK = new Object();

    private BufferedInputStream in;
    private BufferedOutputStream out;

    {
        try {
            in = new BufferedInputStream(new FileInputStream(sourceFile));
            out = new BufferedOutputStream(new FileOutputStream(targetFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String call() throws Exception {
        //这里实现复制功能
        while (true) {
            synchronized (LOCK) {
                byte[] bytes = new byte[5 * 1024];
                int readCount;
                if (fileSize > 0) {
                    readCount = in.read(bytes);
                    out.write(bytes, 0, readCount);
                    fileSize -= readCount;
                    System.out.println(Thread.currentThread().getName() + "复制了" + readCount + "字节，剩余资源量" + fileSize);

                } else {
                    return "src/month1_JavaSE.week4/第1题结果.png";
                }
            }
        }
    }
}