import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test02_5_Delete {
    public static void main(String[] args) {
        JdbcUtils utils = new JdbcUtils();
        Connection conn = utils.getConnection();
        PreparedStatement pst = null;
        String sql = "delete from account where id < ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, 7);
            int count = pst.executeUpdate();
            if(count > 0){
                System.out.println("执行成功，删除了" + count + "行");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
