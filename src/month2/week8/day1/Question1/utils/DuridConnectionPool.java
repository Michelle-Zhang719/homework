package month2.week8.day1.Question1.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-04-17 18:47
 */
public class DuridConnectionPool {
    static DataSource dataSource;

    // DruidDataSourceFactory
    static {

        Properties properties = new Properties();
        try {
            // 读取配置文件
            properties.load(new FileInputStream("druid.properties"));
            // 通过配置文件, 让Druid的DataSource的工厂方法创建一个DataSource对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){

        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
