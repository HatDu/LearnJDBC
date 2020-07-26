import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01_Delete {
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
            String sql = "delete from account where name='Li Si'";
            // 5. 执行sql语句
            int count = stat.executeUpdate(sql);
            if(count > 0){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
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
