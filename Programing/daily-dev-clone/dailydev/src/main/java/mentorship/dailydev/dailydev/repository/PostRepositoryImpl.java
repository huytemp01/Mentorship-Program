package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.PostDao;
import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.RssLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PostRepositoryImpl implements PostRepository{
    @Autowired
    private PostDao postDao;
    @Override
    public int save(List<Post> posts, RssLink link) {
        return postDao.insert(posts, link);
    }

    @Override
    public List<Post> getPostFrom(String domain) {
        return postDao.getPostFrom(domain);
    }

    @Override
    public List<Post> getMostViews() {
        return postDao.getPostsOrderByViewCount();
    }

    @Override
    public List<Post> getPostByRssLink(RssLink rssLink) {
        return postDao.getPostByRssLink(rssLink);
    }
}
