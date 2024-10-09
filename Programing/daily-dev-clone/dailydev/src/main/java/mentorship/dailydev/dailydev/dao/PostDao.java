package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.TagPost;
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
            template.update("INSERT INTO post (title, link, rss_link_id, description, creatorName, pubdate) VALUES(?,?,?,?,?,?)",p.getTitle(), p.getLink(), link.getId(), p.getDescription(),p.getCreatorName(),p.getPublicDateTime());
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
}
