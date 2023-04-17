package month2.week7.day6;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 把昨天的作业的SQL, 由在Navicat运行发给数据库实现数据操作, 改用jdbc 发送数据库实现数据操作;
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

        try{
            //请查出每个导师所带研究生的姓名
            statement.executeUpdate(" SELECT  sta.name as staff_name ,GROUP_CONCAT(stu.name) as student_name\n" +
                    "            from t_staff sta\n" +
                    "            LEFT OUTER JOIN t_stu stu ON stu.tutorid = sta.id\n" +
                    "            GROUP BY sta.name;");


//            -- 2 清查出特定姓名的导师所带研究生的姓名。
//            SELECT  stu.name as student_name
//            FROM t_stu as stu
//            WHERE  tutorid = (SELECT id FROM t_staff sta WHERE sta.name LIKE '高宇宁');
//
//            -- 3 请查出每个导师所带研究生的数量
//            SELECT  sta.name as staff_name ,COUNT(stu.name) as num
//            FROM t_staff sta
//            left OUTER JOIN t_stu stu ON stu.tutorid = sta.id
//            GROUP BY sta.id;
//
//            -- 4 请查出每个导师所带的男研究生的数量
//            SELECT  sta.name as staff_name ,COUNT(stu.name) as num
//            FROM t_staff sta
//            left OUTER JOIN t_stu stu ON stu.tutorid = sta.id
//            WHERE stu.gender = 'male'
//            GROUP BY sta.id;
//
//            -- 5 请找出选择哪个研究方向的导师最多
//            SELECT direction,count(id) as num
//            FROM t_staff
//            GROUP BY direction
//            ORDER BY num desc
//            LIMIT 1;
//
//            -- 6 请找统计不同职称的导师的个数
//            SELECT title,count(id) as num
//            FROM t_staff
//            GROUP BY title;

//            statement.executeUpdate(" update account set   money = money-200 where id  = 1;");
//            statement.executeUpdate(" update account set   money = money-200 where id  = 2;");
//            statement.executeUpdate(" update account set   money = money-200 where id  = 3;");
//            statement.executeUpdate(" update account set   money = money-200 where id  = 4;");
//
//
//            int num = 10;
//            System.out.println(num/0);
//
//            statement.executeUpdate(" update account set   money = money+800 where id  = 5;");

        }catch (Exception e){
            // 如果发生代码运行错误, 回滚(回滚到事务开启的状态)
            connection.rollback();
        }

        // 提交
        connection.commit();



    }
}
