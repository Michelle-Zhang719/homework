package month2.week7.day6.Question2;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description 修改班级id案例class/students表
 * @Author MinjieZhang
 * @Date 2023-04-17 22:31
 */
public class Question2 {

    private static final String url =
            "jdbc:mysql://localhost:3308/java_homework?rewriteBatchedStatements=true&useSSL=false&characterEncoding=utf8";
    private static final String username = "root";
    private static final String password = "o?dCLi22UkbD";

    public static void main(String[] args) throws SQLException {

        new Driver();
        Connection connection = DriverManager.getConnection(url, username, password);


        //  禁止自动提交, 开启事务
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        try{
            //新增班级
            statement.executeUpdate(" insert into class values (4,'1804');");
            //修改学生向致远的班级，转班
            statement.executeUpdate("   update students set   class = 4 where name='向致远';");

        }catch (Exception e){
            // 如果发生代码运行错误, 回滚(回滚到事务开启的状态)
            connection.rollback();
        }

        // 提交
        connection.commit();



    }

}
