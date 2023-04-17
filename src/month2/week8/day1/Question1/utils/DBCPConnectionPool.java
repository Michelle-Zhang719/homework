package month2.week8.day1.Question1.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-04-17 19:41
 */
public class DBCPConnectionPool {
    static DataSource dataSource;

    // BasicDataSourceFactory.createDataSource(properties);
    static {
        Properties properties = new Properties();
        try {
            // 加载配置文件
            properties.load(new FileInputStream("dbcp.properties"));
            // 创建数据库连接池: 通过DBCP的BasicDataSource的工厂方法
            BasicDataSource dataSource1 = BasicDataSourceFactory.createDataSource(properties);

            dataSource = dataSource1;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
