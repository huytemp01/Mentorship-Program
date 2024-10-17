package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class OnlyPostRowMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        int postId = rs.getInt("postId");
        String postTitle = rs.getString("title");
        String description = rs.getString("description");
        String link = rs.getString("link");
        String creatorName = rs.getString("creatorName");
        LocalDateTime pubDate= rs.getTimestamp("pubDate").toLocalDateTime();
        Post post = new Post(postId,postTitle,link,description,creatorName,pubDate);
        return post;
    }
}
