import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

import java.util.Map;

public class Test05_3_JdbcTemplateQueryForMap {
    public static void main(String[] args) {
        JdbcTemplate jt = new JdbcTemplate(DruidUtils.getDs());
        Map<String, Object> map = jt.queryForMap("select id '编号', name '姓名', balance '余额' from account where id=?", 8);
        System.out.println(map);
    }
}
