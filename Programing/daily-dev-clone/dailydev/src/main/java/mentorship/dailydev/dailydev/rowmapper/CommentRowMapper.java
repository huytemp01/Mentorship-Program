package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.Comment;
import mentorship.dailydev.dailydev.domain.User;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRowMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String content = rs.getString("content");

        int userId = rs.getInt("userId");
        String userName = rs.getString("username");

        int repiledComment = rs.getInt("comment_reply_id");

        User user = new User(id,userName);
        Comment comment = new Comment(id, content);
        comment.setUser(user);
        comment.setRepliedTo(repiledComment);
        return comment;
    }
}
