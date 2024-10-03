package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserPostServiceImpl implements UserPostService{
    @Autowired
    private UserPostRepository userPostRepository;
    @Override
    public List<Post> getPostsFromFollowedTags(int id) {
        return userPostRepository.getPostsFromFollowedTags(id);
    }
}
