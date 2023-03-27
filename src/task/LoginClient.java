package task;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-03-25 17:16
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 7777);


        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：用户名");
        String userName = sc.nextLine();
        System.out.println("请输入：密码");
        String userPwd = sc.nextLine();

        //用户对象
        User sendUser = new User(userName, userPwd);

        OutputStream outputStream = socket.getOutputStream();
        // ObjectOutputStream对OutputStream进行包装
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        // writeObject(对象)
        out.writeObject(sendUser);
        //接受提示信息
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream in = new BufferedInputStream(inputStream);

        byte[] buf = new byte[1024];
        int readCount = in.read(buf);
        System.out.println("收到消息" + new String(buf, 0, readCount));

        // close
        socket.close();

    }

}

