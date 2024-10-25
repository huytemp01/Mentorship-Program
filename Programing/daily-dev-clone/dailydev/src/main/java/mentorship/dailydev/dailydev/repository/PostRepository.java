package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.RssLink;

import java.util.List;

public interface PostRepository {
    int save(List<Post> posts, RssLink link);

    List<Post> getPostFrom(String domain);

    List<Post> getMostViews();

    List<Post> getPostByRssLink(RssLink rssLink);
}
