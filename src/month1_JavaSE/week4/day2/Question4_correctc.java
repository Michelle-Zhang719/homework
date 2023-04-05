package month1_JavaSE.week4.day2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * (选做,可最后做)
 * 利用多线程实现破解密码
 * 首先从0-9这10个数中, 生成一个长度是3的随机数字，把这个数字当作密码
 * 创建一个破解线程，使用穷举法，匹配这个密码,直到匹配到正确的,匹配过程中尝试过的数字需要存入一个数组
 * 创建一个日志线程，将该日志线程设置为守护线程。将尝试过的数字写入文件，并将密码的最终结果也写入文件中。
 * 注意: 当Java进程中的所有线程都是守护线程时，JVM退出。所以日志线程打印破解过程，需要在破解完毕后再启动执行。
 *
 * 答：可能出现的情况:
 * - 穷举完了 还没写入 程序就已经终止了
 * - 穷举完了 写了一半 程序就终止了
 * @Author MinjieZhang
 * @Date 2023-03-21 20:55
 */

public class Question4_correctc {
    public static String password;
    //匹配过程中尝试过的数字
    public static String[] passwords = new String[(int) Math.pow(10, 3)];

    public static void main(String[] args) throws InterruptedException {

        // 随机生成密码
        password = createRandomPassword(3);
        System.out.println("password: " + password);
        // 启动穷举线程
        Thread matchThread = new Thread(
                // lambda表达式 也可以用匿名内部类
                () -> matchPassword(password)
        );
        matchThread.start();
        //让main方法等等穷举线程
        matchThread.join();
        // 启动日志线程
        System.out.println(Arrays.toString(passwords));
        Thread logThread = new Thread(
                () -> {
                    try (FileOutputStream out = new FileOutputStream("src/month1_JavaSE.week4/day2/password.txt")) {

                        for (int i = 0; i < passwords.length; i++) {
                            if (passwords[i] != null) {
                                out.write(passwords[i].getBytes());
                                out.write("\r\n".getBytes());
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
        logThread.setDaemon(true);
        logThread.start();
        // 在这睡眠是为了让main线程不死,不死的话那么jvm中就还有用户线程,虚拟机就不会退出
        // 等到日志线程执行完了再死
        Thread.sleep(5000);
    }

    private static void matchPassword(String password) {
        // 所有的可能性就是000 - 999
        // 列一个 不是就放入到数组中
        for (int i = 0; i < passwords.length; i++) {
            /*
                这里进行了一次格式化字符串,表示将不足三位数的int值
                前面补0
                比如对于i=10,possiblePassword就=010
             */
            String possiblePassword = String.format("%03d", i);
            System.out.println(possiblePassword);
            if (password.equals(possiblePassword)) {
                break;
            } else {
                passwords[i] = possiblePassword;
            }
        }

    }

    /**
     *
     * @param len 密码长度
     * @return password
     */
    private static String createRandomPassword(int len) {
        char[] chars = new char[len];
        String s = "123456789";
        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt((int) (Math.random() * s.length()));
        }
        return new String(chars);
    }
}