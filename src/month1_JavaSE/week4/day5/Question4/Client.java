package month1_JavaSE.week4.day5.Question4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP编程练习
 * 客户端键盘录入一个字符串给服务端，服务端将这个字符串消息输出本地的一个文本文件中
 * 客户端传输一个文本文件给服务端，服务端将文本文件中的数据(以字符串形式)输出到控制台
 * 客户端传输一个文本文件给服务端，服务器接收这个文本文件然后将文本文件复制到本地另一个路径
 *
 * @Author MinjieZhang
 * @Date 2023-03-24 16:27
 */
public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 7777);
        Scanner sc = new Scanner(System.in);
        System.out.println("录入字符串------1");
        System.out.println("传文本文件------2");
        System.out.println("退出-----------3");
        System.out.println("请选择：");
        while (true) {
            System.out.println("------------------");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    //客户端键盘录入一个字符串给服务端
                    sc.nextLine();
                    sendString(socket, sc);

                    break;
                case 2:
                    //客户端传文本文件
                    sendFile(socket);
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void sendString(Socket socket, Scanner sc) throws IOException {
        System.out.println("请输入：");
        String msg = sc.nextLine();
        byte[] msgByte = msg.getBytes();

        OutputStream out = socket.getOutputStream();
        out.write(msgByte);
        System.out.println("客户端已经发完字符串了");
        // 关闭资源
        socket.close();

    }

    private static void sendFile(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        FileInputStream in = new FileInputStream("src/month1_JavaSE.week4/day5/Question4/IOTest/a.txt");
        byte[] buf = new byte[1024];
        int readCount;
        while ((readCount = in.read(buf)) != -1) {
            // 循环读,然后将数据写给服务端
            out.write(buf, 0, readCount);
        }
        // 此时不能关闭Socket,也不能关闭socket当中的输入流,因为它们都有用,于是可以考虑关闭输出流
        // 输出流一关闭,就不能再向服务端发消息了,此时服务端的read方法就知道,客户端发送消息结束了!!
        // 关闭socket的输出流,表示已经不再向服务端发送消息了,服务端的read方法可以放心结束read阻塞,继续执行代码
        socket.shutdownOutput();

        // 向服务端发送完数据后,等待服务端的响应,也就是使用socket当中的字节输入流
        InputStream socketIn = socket.getInputStream();
        System.out.println("客户端已经上传完文件了!");
        int readCount2 = socketIn.read(buf);
        System.out.println("服务端给我反馈了,它说: " + new String(buf, 0, readCount2));

        // 关闭资源
        socket.close();
    }
}
