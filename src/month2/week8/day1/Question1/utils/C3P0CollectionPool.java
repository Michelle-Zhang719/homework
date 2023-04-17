package month2.week8.day1.Question1.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-04-17 19:17
 */
public class C3P0CollectionPool {
    static DataSource dataSource;


    static {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        dataSource = comboPooledDataSource;
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
