import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

public class Test05_4_JdbcTemplateQueryForObject {
    public static void main(String[] args) {
        JdbcTemplate jt = new JdbcTemplate(DruidUtils.getDs());
        Integer count = (Integer) jt.queryForObject("select count(id) from account;", Integer.class);
        System.out.println("共" + count + "条数据。");
    }
}

