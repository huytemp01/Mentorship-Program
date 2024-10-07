package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.Source;
import mentorship.dailydev.dailydev.repository.SourceRepository;
import mentorship.dailydev.dailydev.rowmapper.SourceRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SourceDao {
    @Autowired
    private JdbcTemplate template;


    public void insert(String domain) {
        template.update("INSERT INTO source(domain_name) VALUES(?)", domain);
    }

    public Source getBy(String domain) {
        try{
            return template.queryForObject("SELECT id, domain_name FROM source WHERE domain_name = ?", new SourceRowMapper(), domain);

        }
        catch (EmptyResultDataAccessException e){
            return null;
        }

    }

}
