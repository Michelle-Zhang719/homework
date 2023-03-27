package week4.day5.Question3.util;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * 提起出UDP编程下的通用操作,作为一个工具类
 * 1.将要发送的数据封装成数据报包,在封装时,必须明确指出接收端的IP地址和端口号
 * 2.创建一个新的,空的数据报包,用来接收发送端发送的数据报包
 * 3.解析接收到的数据报包,返回数据
 *
 * @author wuguidong@cskaoyan.onaliyun.com
 * @since 10:44
 */
public class UDPNetworkUtils {
    private UDPNetworkUtils() {
    }

    // 1.将要发送的数据封装成数据报包,在封装时,必须明确指出接收端的IP地址和端口号
    // 就假设发送端就发送字符串消息
    public static DatagramPacket getSendPacket(String msg, String targetIp, int targetPort) throws UnknownHostException {
        // 构造数据报包，用来将长度为length偏移量为offset的包发送到指定主机上的指定端口号。
        // DatagramPacket(byte[] buf,  int offset, int length, InetAddress address, int port)
        // 构造数据报包，用来将长度为length的包发送到指定主机上的指定端口号。
        // DatagramPacket(byte[] buf, int length, InetAddress address, int port)

        // 获取一个表示本地主机的InetAddress对象
        // InetAddress address = InetAddress.getLocalHost();
        // 获取一个指定ip地址的InetAddress对象
        // InetAddress address2 = InetAddress.getByName("ip地址");

        // 1.将msg --> byte数组
        byte[] msgBytes = msg.getBytes();
        // 2.将String ip --> InetAddress IP
        InetAddress ip = InetAddress.getByName(targetIp);
        // 3.new对象返回
        return new DatagramPacket(msgBytes, msgBytes.length, ip, targetPort);
    }

    // 2.创建一个新的,空的数据报包,用来接收发送端发送的数据报包
    public static DatagramPacket getReceivePacket() {
        // 构造 DatagramPacket，用来接收长度为length的包，在缓冲区中指定了偏移量。
        // DatagramPacket(byte[] buf, int offset, int length)
        // 构造 DatagramPacket，用来接收长度为length的数据包。
        // DatagramPacket(byte[] buf, int length)
        return new DatagramPacket(new byte[1024], 1024);
    }

    // 3.解析接收到的数据报包,返回数据
    public static String parseMsg(DatagramPacket receivePacket) {
        // DatagramPacket的成员方法
        // 返回数据缓冲区，即数据包封装的字节数据
        // byte[] getData()
        byte[] data = receivePacket.getData();
        // 返回将要发送或接收到的数据的长度。
        // int getLength()
        int length = receivePacket.getLength();
        // 返回将要发送或接收到的数据的偏移量。
        // int getOffset()
        int offset = receivePacket.getOffset();
        // 获取数据包（要发送到的或者发送者）的IP地址
        // InetAddress getAddress()
        // 获取数据包（要发送到的或者发送者）的端口号
        // int getPort()
        // 获取数据包（要发送到的或者发送者）的IP地址和端口号
        // SocketAddress getSocketAddress()
        SocketAddress socketAddress = receivePacket.getSocketAddress();

        return "来自于: " + socketAddress + " , 他发送的消息是: " + new String(data, offset, length);
    }
}
