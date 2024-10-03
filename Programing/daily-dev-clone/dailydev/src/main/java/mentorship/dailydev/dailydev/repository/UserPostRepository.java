package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.Post;

import java.util.List;

public interface UserPostRepository {
    List<Post> getPostsFromFollowedTags(int id);
}
