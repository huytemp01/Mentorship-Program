package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDao {
    @Autowired
    private JdbcTemplate template;


    public void insert(List<Post> posts) {
        for(Post p:posts){
            template.update("INSERT INTO post (title, link, author) VALUES(?,?,?)",p.getTitle(), p.getLink(), p.getCreatorName());
        }
    }
}
