import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Test03_Transaction {
    public static void main(String[] args) {
        JdbcUtils utils = new JdbcUtils();
        Connection conn = utils.getConnection();
        Statement stat1 = null;
        String sql1 = "update account set balance = 10000 where id = 8";
        String sql2 = "update account set balance = 10000 where id = 9";
        try {
            conn.setAutoCommit(false);
            stat1 = conn.createStatement();
            stat1.executeUpdate(sql1);
            int a = 2 / 0;
            stat1.executeUpdate(sql2);
            conn.commit();

        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            utils.close(stat1, conn);
        }
    }
}
