package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.rowmapper.RssLinkRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class RssDao {
    @Autowired
    public JdbcTemplate template;

    public void insert(String rssXml) {
        template.update("INSERT INTO rsslink(rss_link) VALUES(?)", rssXml);
    }

    public boolean isExist(String rssXml) {
        try{
            RssLink rss = template.queryForObject("SELECT id, rss_link FROM rsslink WHERE rss_link = ?", new RssLinkRowMapper(), rssXml);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
