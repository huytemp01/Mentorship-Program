package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.rowmapper.TagRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTagDao {
    @Autowired
    private JdbcTemplate template;
    public void save(int userId, List<Tag> tags) {
        for(Tag tag:tags){
            template.update("INSERT INTO user_follow_tag(user_id, tag_id) VALUES(?,?)", userId, tag.getId());
        }
    }

    public List<Tag> queryTagsUserFollow(int userId) {
         return template.query("SELECT t.id, t.tag_name FROM user_follow_tag ut Join tag t " +
                                                         "On ut.tag_id = t.id " +
                                                         "WHERE user_id=?", new TagRowMapper(), userId);
    }
}
