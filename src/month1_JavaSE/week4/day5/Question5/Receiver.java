package month1_JavaSE.week4.day5.Question5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.util.Properties;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-03-24 19:33
 */
public class Receiver {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9999);
        while (true) {
            //1.实现接受数据并打印在控制台上！！！！！
            //搞一个空的数据包
            byte[] receiveByte = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveByte, 1024);
            //接受从receiver来的数据
            socket.receive(receivePacket);
            byte[] receiveData = receivePacket.getData();
            int receiveDataLen = receivePacket.getLength();
            String receiveMsg = new String(receiveData, 0, receiveDataLen);

            //2.实现自动回复，主要是匹配
            Properties properties = new Properties();
            properties.load(new BufferedReader(new FileReader("src/month1_JavaSE.week4/day5/Question5/robot.properties")));
            String sendMsg = properties.getProperty(receiveMsg);
            if (sendMsg!=null){
                //如果匹配到了
                System.out.println(sendMsg);

            }else{
                sendMsg = "我没听懂你在说什么";
            }

            //3.实现发送数据！！！！
            //将信息包装为数据报包
            byte[] msgBytes = sendMsg.getBytes();
            int receiverPort = 8888;
            InetAddress localHost = InetAddress.getLocalHost();
            DatagramPacket sendPacket = new DatagramPacket(msgBytes, 0, msgBytes.length, localHost, receiverPort);
            //发送数据包
            socket.send(sendPacket);
        }
    }
}
