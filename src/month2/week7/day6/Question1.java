package month2.week7.day6;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * 把昨天的作业的SQL, 由在Navicat运行发给数据库实现数据操作, 改用jdbc 发送数据库实现数据操作;
 *
 * @Author MinjieZhang
 * @Date 2023-04-17 9:11
 */

public class Question1 {


    private static final String url =
            "jdbc:mysql://localhost:3308/java49_wangdao?rewriteBatchedStatements=true&useSSL=false&characterEncoding=utf8";
    private static final String username = "root";
    private static final String password = "o?dCLi22UkbD";

    public static void main(String[] args) throws SQLException {

        new Driver();
        Connection connection = DriverManager.getConnection(url, username, password);


        //  禁止自动提交, 开启事务
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        try {
            //请查出每个导师所带研究生的姓名
            ResultSet resultSet = statement.executeQuery("SELECT  sta.name as staff_name ,GROUP_CONCAT(stu.name) as student_name " +
                    "from t_staff sta  LEFT OUTER JOIN t_stu stu ON stu.tutorid = sta.id GROUP BY sta.name;");
            System.out.println("staff_name" + "  " + "student_name");
            while (resultSet.next()) {
                String staff_name = resultSet.getString("staff_name");
                String student_name = resultSet.getString("student_name");

                System.out.println(staff_name + "  \t" + student_name);
            }


        } catch (Exception e) {
            // 如果发生代码运行错误, 回滚(回滚到事务开启的状态)
            connection.rollback();
        }

        // 提交
        connection.commit();


    }
}
