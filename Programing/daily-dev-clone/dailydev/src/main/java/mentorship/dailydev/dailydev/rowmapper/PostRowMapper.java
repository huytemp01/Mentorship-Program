package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String link = rs.getString("link");
        return new Post(id, link);
    }
}
