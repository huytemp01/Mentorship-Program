package mentorship.dailydev.dailydev.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class RssDao {
    @Autowired
    public JdbcTemplate template;

    public void insert(String rssXml) {
        template.update("INSERT INTO rsslink(rss_link)", rssXml);
    }
}
