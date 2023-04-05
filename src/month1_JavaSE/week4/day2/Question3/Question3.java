package month1_JavaSE.week4.day2.Question3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-03-21 20:36
 */

public class Question3 {
    public static void main(String[] args) {

        NewCopyFile copyFile = new NewCopyFile("src/month1_JavaSE.week4/day2/Question3/test.txt", "src/month1_JavaSE.week4/day2/Question3/IOtest/a.txt");
        Thread t1 = new Thread(copyFile);

        NewCopyFile copyFile2 = new NewCopyFile("src/month1_JavaSE.week4/day2/Question3/test2.txt", "src/month1_JavaSE.week4/day2/Question3/IOtest/b.txt");
        Thread t2 = new Thread(copyFile2);

        NewCopyFile copyFile3 = new NewCopyFile("src/month1_JavaSE.week4/day2/Question3/test3.txt", "src/month1_JavaSE.week4/day2/Question3/IOtest/c.txt");
        Thread t3 = new Thread(copyFile3);
        t1.start();
        t2.start();
        t3.start();
    }
}

class NewCopyFile implements Runnable {
    //源文件路径
    File older;
    //目标文件路径
    File newer;

    //构造方法
    public NewCopyFile(String older, String newer) {
        this.older = new File(older);
        this.newer = new File(newer);
    }

    //重写run方法
    @Override
    public void run() {
        //复制进度可以用当前已循环读写的字节和除以文件大小字节

        //创建字节输入，输出流对象
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(older);
            out = new FileOutputStream(newer);

            //存每次读取到的数据
            byte[] bytes = new byte[1024];
            //存贮read方法返回的实际读取的字节数量
            int readCount = 0;
            //源文件长度
            long fileLen = older.length();

            //目前读到多少字节
            double currentLen = 0;
            //循环读+写
            while ((readCount = in.read(bytes)) != -1) {
                out.write(bytes, 0, readCount);
                currentLen += readCount;
                //计算已读长度占比
                double rate = currentLen / fileLen;
                System.out.println(older.getName() + "文件已复制" + Math.round(rate * 100) + "%");

            }
            System.out.println(older.getName() + "复制完成！");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}