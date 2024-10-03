package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.repository.UserTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserTagServiceImpl implements UserTagService{
    @Autowired
    private UserTagRepository userTagRepository;
    @Override
    public void followTags(int userId, List<Tag> tags) {
        userTagRepository.save(userId,tags);
    }

    @Override
    public List<Tag> getFollowTags(int userId) {
        return userTagRepository.getFollowTags(userId);
    }
}
