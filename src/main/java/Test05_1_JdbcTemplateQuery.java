import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.Account;
import utils.DruidUtils;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Test05_1_JdbcTemplateQuery {
    public static void main(String[] args) {
        DataSource ds = DruidUtils.getDs();
        JdbcTemplate jt = new JdbcTemplate(ds);
//        List<Account> acList = jt.query("select * from account;", new RowMapper<Account>() {
//            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
//                Account ac = new Account();
//                ac.setId(resultSet.getInt("id"));
//                ac.setName(resultSet.getString("name"));
//                ac.setBalance(resultSet.getInt("balance"));
//                return ac;
//            }
//        });
        String sql = "select * from account;";
        List<Account> acList = jt.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(acList);
    }
}
