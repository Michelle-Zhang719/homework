package month2.week8.day1.Question2.utils;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description 数据库连接
 * @Author MinjieZhang
 * @Date 2023-04-17 20:28
 */

public class JDBCConnection {

    public static Connection getConnection(){

        try {
            new Driver();

            Connection connection = DriverManager.getConnection(
                    ReadProperties.getUrl(), ReadProperties.getUsername(), ReadProperties.getPassword());
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
