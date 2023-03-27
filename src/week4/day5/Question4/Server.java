package week4.day5.Question4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP练习
 * 1.客户端键盘录入，服务器输出文本文件
 * 2.客户端文本文件，服务器输出到控制台
 * 3.客户端文本文件，服务器输出文本文件
 *
 * @Author MinjieZhang
 * @Date 2023-03-24 16:27
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建服务端的ServerSocket对象，需要指定一个监听的端口来监听是否有客户端进行连接
        ServerSocket serverSocket = new ServerSocket(7777);
        Scanner sc = new Scanner(System.in);
        //2.利用accept方法建立连接，得到Socke对象
        Socket socket = serverSocket.accept();
        System.out.println("输出文本文件------1");
        System.out.println("输出到控制台------2");
        System.out.println("退出-----------3");
        System.out.println("请选择：");
        while (true) {
            System.out.println("-----------------");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    //输出文本文件
                    textFile(socket);
                    // 关闭资源
                    serverSocket.close();
                    break;
                case 2:

                    //输出到控制台
                    keyboard(socket);
                    // 关闭资源
                    serverSocket.close();
                    break;
                case 3:
                    return;
            }
        }


    }

    private static void keyboard(Socket socket) throws IOException {
        System.out.println("客户端已经连接了!");
        //3.服务端没有自己的流用于数据操作，而是从Socket流中获取输入、输出流,从客户端读取数据
        InputStream in = socket.getInputStream();

        //输出文本文件！！！！！！！！
        byte[] buf = new byte[1024];
        int readCount = in.read(buf);
        System.out.println("收到消息"+new String(buf, 0, readCount));

    }

    private static void textFile(Socket socket) throws IOException {
        System.out.println("客户端已经连接了!");
        //3.服务端没有自己的流用于数据操作，而是从Socket流中获取输入、输出流,从客户端读取数据
        InputStream in = socket.getInputStream();

        //输出文本文件！！！！！！！！
        byte[] buf = new byte[1024];
        //复制到新得文件夹种
        FileOutputStream out = new FileOutputStream("src/week4/day5/test.txt");
        int readCount;
        // 这个输入流是从网络传输中读取数据,此时没有文件指针告诉它已经读完了,所以它就会一直等待,继续等待数据输入
        // 所以这里为了不让read方法阻塞,需要告诉这个输入流,已经读完了
        while ((readCount = in.read(buf)) != -1) {
            // 循环读,循环写,直接将文件数据写到外存文件中
            out.write(buf, 0, readCount);
        }
        System.out.println("服务端已经接收完文件了!");
        // 此时服务端已经接收完毕文件了,于是向客户端反馈消息
        // 使用socket当中的字节输出流
        OutputStream socketOut = socket.getOutputStream();
    }
}