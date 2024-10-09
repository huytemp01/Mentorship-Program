package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.Tag;

import java.util.HashMap;
import java.util.List;

public interface TagPostService {
    List<Post> getPostsFromTagsFollowedByUser(int userId);
}
