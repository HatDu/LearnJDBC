import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class Test02_1_JDBCUtils {
    Connection connection;
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static {
        Properties properties = new Properties();
        try {
            // 获取src路径下的文件
            ClassLoader classLoader = Test02_1_JDBCUtils.class.getClassLoader();
            String filePath = classLoader.getResource("jdbc.properties").getPath();
            // filePath = "C:\\Users\\dnm\\Documents\\Google Drive\\jdbc.properties";
            // filePath = "/C:/Users/dnm/Documents/Google Drive/IDEA/LearnJDBC/target/classes/jdbc.properties";
            filePath = filePath.replace("%20", " ");
            System.out.println(filePath);
            properties.load(new FileInputStream(filePath));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Test02_1_JDBCUtils() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * 释放资源
     */
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
