package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.Comment;
import mentorship.dailydev.dailydev.rowmapper.CommentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentDao {
    @Autowired
    private JdbcTemplate template;
    public List<Comment> getByPostId(int postId) {
        return template.query("SELECT c.id, c.content, c.comment_reply_id, u.id as userId, u.user_name as username " +
                "FROM Comment c JOIN Users u ON c.user_id=u.id " +
                "WHERE c.post_id=? " +
                "ORDER BY c.comment_reply_id", new CommentRowMapper(), postId);
    }
}
