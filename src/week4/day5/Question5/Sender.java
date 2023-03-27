package week4.day5.Question5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-03-24 19:33
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        //用于发送
        DatagramSocket socket = new DatagramSocket(8888);
        Scanner sc = new Scanner(System.in);
        while (true) {
            //实现发送数据！！！！
            System.out.println("可以开始聊天啦");
            String msg = sc.nextLine();

            //1.将信息包装为数据报包
            byte[] msgBytes = msg.getBytes();
            int receiverPort = 9999;
            InetAddress localHost = InetAddress.getLocalHost();
            DatagramPacket sendPacket = new DatagramPacket(msgBytes, 0, msgBytes.length, localHost, receiverPort);
            //发送数据包
            socket.send(sendPacket);

            //2.实现接受数据并打印在控制台上！！！！！
            //搞一个空的数据包
            byte[] receiveByte = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveByte, 1024);
            //接受从receiver来的数据
            socket.receive(receivePacket);
            byte[] receiveData = receivePacket.getData();
            System.out.println(new String(receiveData));

        }

    }
}
