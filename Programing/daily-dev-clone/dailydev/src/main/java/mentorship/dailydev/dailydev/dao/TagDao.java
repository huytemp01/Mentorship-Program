package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.rowmapper.TagRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TagDao {
    @Autowired
    private JdbcTemplate template;
    public List<Tag> getAll() {
        return template.query("SELECT id, tag_name FROM Tag", new TagRowMapper());
    }
}
