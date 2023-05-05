package month1_JavaSE.week4.day5.Question3;

import month1_JavaSE.week4.day5.Question3.util.UDPNetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 参考上课代码,使用UDP尝试跟自己的同桌实现通信
 *
 * @author wuguidong@cskaoyan.onaliyun.com
 * @since 11:27
 */
public class Question3 {
    public static void main(String[] args) throws SocketException {
        //我的端口
        DatagramSocket socket = new DatagramSocket(9999);
        // 创建两个线程,执行发送和接收的任务，我同桌的ip和端口号
        new Thread(new SenderTask("192.168.6.145", 8765, socket), "右边的同桌！").start();
        new Thread(new ReceiverTask(socket)).start();
    }
}

//接收端的任务
class ReceiverTask implements Runnable {
    private DatagramSocket socket;

    public ReceiverTask(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            DatagramPacket receivePacket = UDPNetworkUtils.getReceivePacket();
            try {
                socket.receive(receivePacket);
                // 解析处理消息
                System.out.println(UDPNetworkUtils.parseMsg(receivePacket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//发送端的任务
class SenderTask implements Runnable {
    private String targetIp;
    private int targetPort;
    private DatagramSocket socket;

    public SenderTask(String targetIp, int targetPort, DatagramSocket socket) {
        this.targetIp = targetIp;
        this.targetPort = targetPort;
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入给" + Thread.currentThread().getName() + "发送的消息:");
            String msg = sc.nextLine();
            try {
                DatagramPacket sendPacket = UDPNetworkUtils.getSendPacket(msg, targetIp, targetPort);
                // 发送
                socket.send(sendPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
