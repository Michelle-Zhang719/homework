package month1_JavaSE.week4.day2.Question1;

import java.io.*;

/**
 * 使用多线程实现方式一来实现多个文件一起复制功能(3个线程复制3个文件)，并在控制台显示复制的进度，进度以百分比表示
 * 例如：把文件A复制到E盘某文件夹下，在控制台上显示“XXX文件已复制xx%”，“XXX文件已复制xxx%”……“XXX文件已复制xxx%”，“XXX复制完成！”
 * 注: 为了更好的显示百分比推荐使用字节流进行复制操作
 * 提示: 进度可以用当前已循环读写的字节和除以文件大小字节
 *
 * @Author MinjieZhang
 * @Date 2023-03-21 19:03
 */
public class Question1 {
    public static void main(String[] args) {

        CopyFile copyFile = new CopyFile("src/month1_JavaSE.week4/day2/Question1/test.txt", "src/month1_JavaSE.week4/day2/Question1/IOtest/a.txt");
        copyFile.start();

        CopyFile copyFile2 = new CopyFile("src/month1_JavaSE.week4/day2/Question1/test2.txt", "src/month1_JavaSE.week4/day2/Question1/IOtest/b.txt");
        copyFile2.start();

        CopyFile copyFile3 = new CopyFile("src/month1_JavaSE.week4/day2/Question1/test3.txt", "src/month1_JavaSE.week4/day2/Question1/IOtest/c.txt");
        copyFile3.start();
    }
}

class CopyFile extends Thread {
    //源文件路径
    File older;
    //目标文件路径
    File newer;

    //构造方法
    public CopyFile(String older, String newer) {
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