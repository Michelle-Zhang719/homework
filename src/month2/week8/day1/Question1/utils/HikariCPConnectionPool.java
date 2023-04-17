package month2.week8.day1.Question1.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-04-17 19:57
 */
public class HikariCPConnectionPool {
    static DataSource dataSource;

    static {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("hikaricp.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HikariConfig config = new HikariConfig(properties);
        dataSource = new HikariDataSource(config);
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
