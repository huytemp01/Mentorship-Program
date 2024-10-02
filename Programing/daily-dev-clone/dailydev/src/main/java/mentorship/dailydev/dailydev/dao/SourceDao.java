package mentorship.dailydev.dailydev.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SourceDao {
    private JdbcTemplate template;


    public void insert(String domain) {
        template.update("INSERT INTO source(domain_name) VALUES(?)", domain);
    }
}
