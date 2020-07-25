import java.sql.*;

public class Test01_Insert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
            // 3. 获取sql执行对象
            stat = conn.createStatement();
            // 4。 声明sql语句
            String sql = "insert into account values(null, 'Li Si', 800)";
            // 5. 执行sql语句
            int count = stat.executeUpdate(sql);
            if(count > 0){
                System.out.println("插入成功！");
            }else{
                System.out.println("插入失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(stat != null) {
                try {
                    stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
