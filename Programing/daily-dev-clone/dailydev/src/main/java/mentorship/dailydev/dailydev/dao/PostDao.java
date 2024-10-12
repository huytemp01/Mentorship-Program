package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.TagPost;
import mentorship.dailydev.dailydev.rowmapper.OnlyPostRowMapper;
import mentorship.dailydev.dailydev.rowmapper.PostRowMapper;
import mentorship.dailydev.dailydev.rowmapper.TagPostRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDao {
    @Autowired
    private JdbcTemplate template;


    public void insert(List<Post> posts, RssLink link) {
        for(Post p:posts){
            template.update("INSERT INTO post (title, link, rss_link_id, description, creatorName, pubdate, view_count) VALUES(?,?,?,?,?,?,?)",p.getTitle(), p.getLink(), link.getId(), p.getDescription(),p.getCreatorName(),p.getPublicDateTime(),0);
        }
    }

    public List<TagPost> getPostForUser(int userId) {
        List<TagPost> list = template.query("SELECT t.id as tagId,t.tag_name as tagName ,p.id as postId,p.title,p.description,p.link,p.count_upvote,p.count_downvote,p.creatorName,p.pubDate,p.rss_link_id" +
                " FROM post p JOIN post_tag pt ON p.id = pt.post_id " +
                " JOIN tag t ON t.id = pt.tag_id " +
                " JOIN user_follow_tag uft ON t.id = uft.tag_id" +
                " JOIN users u on u.id = uft.user_id" +
                " WHERE u.id = ?", new TagPostRowMapper(), userId);

        return list;
    }

    public List<Post> getPostFrom(String domain) {
        List<Post> list = template.query("SELECT t.id as tagId, t.tag_name as tagName, p.id as postId,p.title,p.description,p.link,p.count_upvote,p.count_downvote,p.creatorName,p.pubDate,p.rss_link_id" +
                " FROM post p JOIN post_tag pt ON p.id = pt.post_id " +
                " JOIN tag t ON t.id = pt.tag_id " +
                " JOIN rsslink r ON p.rss_link_id = r.id " +
                " JOIN source s ON s.id = r.source_id " +
                " WHERE s.domain_name = ?" , new PostRowMapper(), domain);
        return list;
    }

    public List<Post> getPostsOrderByViewCount() {
        List<Post> list = template.query("SELECT t.id as tagId, t.tag_name as tagName, p.id as postId,p.title,p.description,p.link,p.count_upvote,p.count_downvote,p.creatorName,p.pubDate,p.rss_link_id" +
                " FROM post p JOIN post_tag pt ON p.id = pt.post_id " +
                " JOIN tag t ON t.id = pt.tag_id " +
                " JOIN rsslink r ON p.rss_link_id = r.id " +
                " JOIN source s ON s.id = r.source_id " +
                " ORDER BY p.view_count " , new PostRowMapper());
        return list;
    }

    public List<Post> getPostByRssLink(RssLink rssLink) {
        return template.query("SELECT p.id as postId,p.title,p.description,p.link,p.count_upvote,p.count_downvote,p.creatorName,p.pubDate,p.rss_link_id" +
                " FROM post p WHERE rss_link_id = ?", new OnlyPostRowMapper(), rssLink.getId() );
    }
}
