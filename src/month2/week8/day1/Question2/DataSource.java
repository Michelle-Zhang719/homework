package month2.week8.day1.Question2;

import month2.week8.day1.Question2.utils.MyConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-04-17 20:29
 */

public class DataSource {
    public static void main(String[] args) throws SQLException {


        Connection connection = MyConnectionPool.getConnection();

        Statement statement = connection.createStatement();

        // SQL操作
        ResultSet resultSet = statement.executeQuery("select * from user; ");

        while (resultSet.next()){

            int id = resultSet.getInt("id");
            String userName = resultSet.getString("user_name");
            String address = resultSet.getString("address");

            System.out.println(id + "  " + userName + "   " + address);
        }


        MyConnectionPool.returnConnection( connection);

        statement.close();

    }
}