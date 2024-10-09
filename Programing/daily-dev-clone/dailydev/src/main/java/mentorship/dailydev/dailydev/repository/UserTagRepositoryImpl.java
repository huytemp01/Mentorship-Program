package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.UserTagDao;
import mentorship.dailydev.dailydev.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserTagRepositoryImpl implements UserTagRepository{
    @Autowired
    private UserTagDao userTagDao;
    @Override
    public void save(int userId, List<Tag> tags) {
        userTagDao.save(userId, tags);
    }

    @Override
    public List<Tag> getFollowTags(int userId) {
        return userTagDao.queryTagsUserFollow(userId);
    }

    @Override
    public List<Tag> getFollowTags(String email) {
        return userTagDao.queryTagsUserFollow(email);
    }
}
