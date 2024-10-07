package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.Post;

import java.util.List;

public interface PostRepository {
    void save(List<Post> posts);
}
