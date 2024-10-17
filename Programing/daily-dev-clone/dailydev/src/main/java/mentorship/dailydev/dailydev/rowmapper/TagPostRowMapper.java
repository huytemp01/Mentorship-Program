package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.domain.TagPost;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

public class TagPostRowMapper implements RowMapper<TagPost> {
    @Override
    public TagPost mapRow(ResultSet rs, int rowNum) throws SQLException {
        int tagId = rs.getInt("tagId");
        String tagName = rs.getString("tagName");
        Tag tag = new Tag(tagId,tagName);

        int postId = rs.getInt("postId");
        String postTitle = rs.getString("title");
        String description = rs.getString("description");
        String link = rs.getString("link");
        String creatorName = rs.getString("creatorName");
        LocalDateTime pubDate= rs.getTimestamp("pubDate").toLocalDateTime();
        Post post = new Post(postId,postTitle,link,description,creatorName,pubDate);

        return new TagPost(tag,post);
    }
}
