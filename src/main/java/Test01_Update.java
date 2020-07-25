import java.sql.*;

public class Test01_Update {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
            stat = conn.createStatement();
            String sql = "update account set name = 'Du Nianmao' where id = 3";
            int count = stat.executeUpdate(sql);
            if(count > 0){
                System.out.println("更新成功！");
            }else{
                System.out.println("更新失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(stat!=null){
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
