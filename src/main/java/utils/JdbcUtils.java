package utils;

import javax.print.DocFlavor;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static Connection connection;
    private static String db_url;
    private static String user;
    private static String password;
    private static String driver;
    static {
        String path = JdbcUtils.class.getClassLoader().getResource("jdbc.properties").getPath();
        path = path.replace("%20", " ");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
            db_url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
            connection = DriverManager.getConnection(db_url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void close(Statement stat, Connection conn){
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close(conn);
    }

    public void close(ResultSet rs, Statement stat, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close(stat, conn);
    }
}
