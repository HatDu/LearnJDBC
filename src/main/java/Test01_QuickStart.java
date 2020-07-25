import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test01_QuickStart {
    public static void main(String[] args) throws Exception {
        // 1. 导入数据库jar包
        // 2. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 3. 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
        // 4. 定义sql语句
        // 4.1 创建表
        String sql = "CREATE TABLE `account` (\n" +
                "  `id` int AUTO_INCREMENT,\n" +
                "  `name` varchar(10) UNIQUE,\n" +
                "  `balance` int,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;";
        // 5. 获取执行sql的Statement对象
        Statement stmt = conn.createStatement();
        // 6. 执行sql语句
        int count = stmt.executeUpdate(sql);
        System.out.println(count);
        // 7. 释放资源
        stmt.close();
        conn.close();
    }
}
