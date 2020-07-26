import utils.DruidUtils;

import java.sql.Connection;

public class Test04_4_GetMaxConnection {
    public static void main(String[] args) {
        int n = 11;
        for(int i = 0; i < n; i++){
            Connection conn = DruidUtils.getConnection();
            System.out.println(conn);
        }
    }
}
