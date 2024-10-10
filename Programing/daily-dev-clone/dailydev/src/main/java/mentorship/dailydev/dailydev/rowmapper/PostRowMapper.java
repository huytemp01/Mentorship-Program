package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.Tag;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PostRowMapper implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        int postId = rs.getInt("postId");
        String postTitle = rs.getString("title");
        String description = rs.getString("description");
        String link = rs.getString("link");
        String creatorName = rs.getString("creatorName");
        LocalDateTime pubDate= rs.getTimestamp("pubDate").toLocalDateTime();
        Post post = new Post(postId,postTitle,link,description,creatorName,pubDate,null);

        int tagId = rs.getInt("tagId");
        String tagName = rs.getString("tagName");
        Tag tag = new Tag(tagId,tagName);
        post.addTag(tag);
        return post;
    }
}
