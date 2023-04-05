package month1_JavaSE.task;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-03-25 17:16
 */
public class LoginServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        //1.创建服务端的ServerSocket对象，需要指定一个监听的端口来监听是否有客户端进行连接
        ServerSocket serverSocket = new ServerSocket(7777);
        //2.利用accept方法建立连接，得到Socke对象
        Socket socket = serverSocket.accept();
        System.out.println("客户端已经连接了!");
        //3.服务端没有自己的流用于数据操作，而是从Socket流中获取输入、输出流,从客户端读取数据
        InputStream inputStream = socket.getInputStream();

        // 对输入流进行包装 对象流
        ObjectInputStream in = new ObjectInputStream(inputStream);
        // readObject()
        User user = (User) in.readObject();
        User correct = new User("admin", "admin");

        //输出提示信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream out = new BufferedOutputStream(outputStream);

        if (correct.equals(user)) {
            out.write("成功登录".getBytes());

        } else {
            out.write("登录失败".getBytes());
        }
        System.out.println("已返回提示信息");
        out.flush();

        socket.close();

        serverSocket.close();
    }
}
