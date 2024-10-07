package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.Tag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagRowMapper implements RowMapper<Tag> {
    @Override
    public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String tagName = rs.getString("tag_name");
        return new Tag(id, tagName);
    }
}
