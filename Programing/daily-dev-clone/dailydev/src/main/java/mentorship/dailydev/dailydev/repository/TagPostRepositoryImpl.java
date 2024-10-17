package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.PostDao;
import mentorship.dailydev.dailydev.domain.TagPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagPostRepositoryImpl implements  TagPostRepository{
    @Autowired
    private PostDao postDao;
    @Override
    public List<TagPost> getPostsForUser(int userId) {
        List<TagPost> posts =  postDao.getPostForUser(userId);
        return posts;
//        return postDao.getPostForUser(userId);
    }
}
