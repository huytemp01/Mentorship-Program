package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.rowmapper.RssLinkRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RssDao {
    @Autowired
    public JdbcTemplate template;

    public void insert(String rssXml, int categoryId, int sourceId) {
        template.update("INSERT INTO rsslink(rss_link,category_id,source_id ) VALUES(?,?,?)", rssXml, categoryId,sourceId);
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

    public RssLink getBy(String rssXml) {
        return template.queryForObject("SELECT id, rss_link FROM rsslink WHERE rss_link = ?", new RssLinkRowMapper(), rssXml);
    }

    public List<RssLink> getAllRssLinks() {
        return template.query("SELECT id, rss_link FROM rsslink", new RssLinkRowMapper());
    }

    public List<RssLink> getLinks(int limit, int offset) {
        return template.query("SELECT id, rss_link FROM rsslink ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY", new RssLinkRowMapper(), offset, limit);
    }

    public int count() {
        return template.queryForObject("SELECT Count(id) FROM rsslink", Integer.class);
    }

    public RssLink getById(int rssId) {
        return template.queryForObject("SELECT id, rss_link FROM rsslink WHERE id=?", new RssLinkRowMapper(), rssId);
    }
}
