package week4.day4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 写1个定时任务,3s的延迟后,每隔5s向文件中写入一行当前时间
 *
 * @Author MinjieZhang
 * @Date 2023-03-23 19:48
 */
public class Question4 {
    private static int count = 0;

    public static void main(String[] args) {
        // 创建一个定时器
        Timer timer = new Timer();

        // 用匿名内部类对象创建一个定时任务
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //获取当前时间戳
                long currentTime = System.currentTimeMillis();
                //确定时间格式
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                //转换格式
                String time = sdf.format(currentTime);

                BufferedWriter out = null;
                try {
                    out = new BufferedWriter(new FileWriter("src/week4/day4/IOtest/time.txt", true));
                    out.write(time + "\r\n");
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("写入" + time);
                count++;
                //写6个时间
                if (count >= 5) {
                    timer.cancel();
                }

            }
        };
        // 安排指定的任务从指定的延迟后开始进行重复的固定延迟执行。每次任务之间的间隔为period
        // void schedule(TimerTask task, long delay, long period)
        timer.schedule(task, 3000, 5000);
    }
}
