package month2.week8.day1.Question1;

import month2.week8.day1.Question1.utils.C3P0CollectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-04-17 19:25
 */
public class C3P0 {
    public static void main(String[] args) throws SQLException {


        Connection connection = C3P0CollectionPool.getConnection();
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

        statement.close();


        // 知识点: 并没有真正的close, 因为已经重写了close
        //         这个close只不过把链接返回到数据库连接池
        connection.close();

    }
}
