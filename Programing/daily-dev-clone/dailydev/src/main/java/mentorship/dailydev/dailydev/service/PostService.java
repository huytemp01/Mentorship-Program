package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostsFromSource(String domain);

    List<Post> getTheMostViews();
}
