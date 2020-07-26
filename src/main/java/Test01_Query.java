import java.sql.*;

public class Test01_Query {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
            // 3. 获取sql执行对象
            stat = conn.createStatement();
            // 4。 声明sql语句
            String sql = "select * from account";
            // 5. 执行sql语句
            rs = stat.executeQuery(sql);
            // rs.next();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name");
                int balance = rs.getInt("balance");
                System.out.println("id=" + id + ",name=" + name + ",balance=" + balance);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
