import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02_3_InsertMany {
    public static void main(String[] args) {
        Test02_1_JDBCUtils utils = new Test02_1_JDBCUtils();
        Connection conn = utils.getConnection();

        PreparedStatement pst = null;
        try {
            String sql = "insert into account values(null, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "王康明");
            pst.setInt(2, 51204);
            int count = pst.executeUpdate();
            if(count > 0){
                System.out.println("插入成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            utils.close(pst, conn);
        }

    }
}
