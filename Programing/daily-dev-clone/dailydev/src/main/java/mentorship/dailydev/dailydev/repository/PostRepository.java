package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.RssLink;

import java.util.List;

public interface PostRepository {
    void save(List<Post> posts, RssLink link);
}
