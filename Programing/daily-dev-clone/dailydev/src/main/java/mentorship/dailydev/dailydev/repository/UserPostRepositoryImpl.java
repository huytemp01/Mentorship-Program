package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.UserPostDao;
import mentorship.dailydev.dailydev.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserPostRepositoryImpl implements UserPostRepository{
    @Autowired
    private UserPostDao userPostDao;
    @Override
    public List<Post> getPostsFromFollowedTags(int id) {
        return userPostDao.getPostsForUserId(id);
    }
}
