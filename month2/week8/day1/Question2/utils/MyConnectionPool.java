package month2.week8.day1.Question2.utils;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * @Description 构建数据库连接池
 * @Author MinjieZhang
 * @Date 2023-04-17 20:27
 */
public class MyConnectionPool {

    // 维护一个连接的容器: 存储多个数据库连接
    static ArrayList<Connection> connections;

    static {
        connections = new ArrayList<>();
        initConnection(ReadProperties.getInitcapacity());

//        try {
//            new Driver();
//            for (int i = 0; i < INIT_CAPACITY; i++) {
//
//                // 创建一个连接
//                Connection connection = DriverManager.getConnection(
//                        "", "", "");
//                // 放到连接池所持有的容器中
//                connections.add(connection);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }


    /**
     * 提供给外界获取连接的方法
     * @return: 一个数据库连接
     */
    public static Connection getConnection(){
        // 判断底层容器是否存储的还有连接(当用的比较多的时候, 都被别人拿走了)
        if (connections.size() < 5){
            //增量
            initConnection(ReadProperties.getIncrement());
        }

        // 从底层容器中取出一个连接(删除掉, 获得这个删除的连接的引用)
        Connection remove = connections.remove(0);

        // 把取出的连接返回给外界
        return remove;
    }

    // 根据指定长度, 扩容容器中的连接数
    private static void initConnection(int capacity) {
        for (int i = 0; i < capacity; i++) {

            // 获取一个连接
            Connection connection = JDBCConnection.getConnection();
            // 放到连接池所持有的容器中
            connections.add(connection);
        }
    }

    /**
     * 外界可以调用的归还连接的方法
     * @param connection: 要归还的连接
     */
    public static void returnConnection(Connection connection){
        // 把连接放到归还的底层容器中去
        connections.add(connection);
    }
}