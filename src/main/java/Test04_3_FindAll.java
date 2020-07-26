import utils.DruidUtils;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test04_3_FindAll {
    public static void main(String[] args) {
        Connection conn = DruidUtils.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select * from account";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int balance = rs.getInt("balance");
                System.out.println("id=" + id +", name=" + name + ", balance=" + balance);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
