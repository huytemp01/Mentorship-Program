package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.rowmapper.PostRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserPostDao {
    @Autowired
    private JdbcTemplate template;
    public List<Post> getPostsForUserId(int id) {
        return template.query("SELECT DISTINCT p.id, CAST(p.link AS VARCHAR(MAX)) as link FROM post p JOIN post_tag pt ON p.id = pt.post_id " +
                "JOIN tag t ON t.id = pt.tag_id " +
                "JOIN user_follow_tag uft ON uft.tag_id = t.id " +
                "WHERE uft.user_id = ?", new PostRowMapper(),id);

//        return template.query("")

    }
}
