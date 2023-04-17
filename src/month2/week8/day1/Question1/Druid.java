package month2.week8.day1.Question1;


import month2.week8.day1.Question1.utils.DuridConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-04-17 18:40
 */
public class Druid {
    public static void main(String[] args) throws SQLException {

        Connection connection = DuridConnectionPool.getConnection();
        Statement statement = connection.createStatement();
        //增
        statement.executeUpdate(" insert t_staff values(125,'邹华','教授','机器识别');");
        //删
        statement.executeUpdate(" delete from t_staff where id=128;");
        //改
        statement.executeUpdate(" update t_staff set   title = '教授' where id  = 101;");
        //查
        ResultSet resultSet = statement.executeQuery("select * from t_staff");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String title = resultSet.getString("title");
            String direction = resultSet.getString("direction");
            System.out.println(id+","+name+","+title+","+direction);
        }

        connection.close();
        statement.close();
    }
}
