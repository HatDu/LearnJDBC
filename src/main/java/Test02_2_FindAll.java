import java.sql.*;

public class Test02_2_FindAll {
    public static void main(String[] args) {
        Test02_1_JDBCUtils utils = new Test02_1_JDBCUtils();
        Connection conn = utils.getConnection();
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
            utils.close(rs, pst, conn);
        }
    }
}
