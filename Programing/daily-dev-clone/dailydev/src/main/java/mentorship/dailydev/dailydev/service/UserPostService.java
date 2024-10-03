package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Post;

import java.util.List;

public interface UserPostService {
    List<Post> getPostsFromFollowedTags(int id);
}
