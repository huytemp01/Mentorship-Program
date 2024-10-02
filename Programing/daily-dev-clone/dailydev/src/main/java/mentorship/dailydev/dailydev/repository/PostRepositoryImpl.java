package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.PostDao;
import mentorship.dailydev.dailydev.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PostRepositoryImpl implements PostRepository{
    @Autowired
    private PostDao postDao;
    @Override
    public void save(List<Post> posts) {
        postDao.insert(posts);
    }
}