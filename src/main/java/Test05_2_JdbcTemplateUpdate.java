import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

public class Test05_2_JdbcTemplateUpdate {
    public static void main(String[] args) {
        JdbcTemplate jt = new JdbcTemplate(DruidUtils.getDs());
        int count = jt.update("update account set balance=? where id >= ?", 15000, 8);
        System.out.println("更新了" + count + "行");
    }
}
