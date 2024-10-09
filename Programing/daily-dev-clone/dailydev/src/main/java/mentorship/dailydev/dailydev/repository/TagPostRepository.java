package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.TagPost;

import java.util.List;

public interface TagPostRepository {
    List<TagPost> getPostsForUser(int userId);
}
