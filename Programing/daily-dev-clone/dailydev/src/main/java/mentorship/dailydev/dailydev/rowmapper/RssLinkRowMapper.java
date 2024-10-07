package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.RssLink;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RssLinkRowMapper implements RowMapper<RssLink> {
    @Override
    public RssLink mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String rssLink = rs.getString("rss_link");
        return new RssLink(id, rssLink);
    }
}
