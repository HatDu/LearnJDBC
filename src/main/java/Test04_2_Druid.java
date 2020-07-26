import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

public class Test04_2_Druid {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String path =Test04_2_Druid.class.getClassLoader().getResource("druid.properties").getPath();
        path = path.replace("%20", " ");
        try {
            properties.load(new FileInputStream(path));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
