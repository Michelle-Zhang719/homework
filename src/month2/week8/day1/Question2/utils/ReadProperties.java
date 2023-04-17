package month2.week8.day1.Question2.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description  工具类 读取配置文件内的信息
 * @Author MinjieZhang
 * @Date 2023-04-17 21:26
 */
public class ReadProperties {
    private static final String url;
    private static final String username;
    private static final String password;
    //初始化大小
    private static final int initcapacity;
    //增量大小
    private static final int increment;
    //最小连接数
    private static final int minNumConnections;

    static{
        // 通过读取配置文件，获取数据
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        initcapacity = Integer.parseInt(properties.getProperty("initcapacity"));
        increment = Integer.parseInt(properties.getProperty("increment"));
        minNumConnections = Integer.parseInt(properties.getProperty("minNumConnections"));
    }

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static int getInitcapacity() {
        return initcapacity;
    }

    public static int getIncrement() {
        return increment;
    }

    public static int getMinNumConnections() {
        return minNumConnections;
    }
}
