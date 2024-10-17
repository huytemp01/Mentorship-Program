package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<Post> getPostsFromSource(String domain) {
        List<Post> posts = postRepository.getPostFrom(domain);
        Map<String,Post> postMap = new HashMap<>();
        for(Post p:posts){
            String link = p.getLink();
            if(postMap.containsKey(link)){
                Post post = postMap.get(link);
                post.addTag(p.getTags().get(0));
            }
            else {
                postMap.put(link, p);
            }

        }
        List<Post> uniquePosts = new ArrayList<>();
        for(Post p:postMap.values()){
            uniquePosts.add(p);
        }

        return uniquePosts;
    }

    @Override
    public List<Post> getTheMostViews() {
        List<Post> posts = postRepository.getMostViews();
        Map<String,Post> postMap = new HashMap<>();
        for(Post p:posts){
            String link = p.getLink();
            if(postMap.containsKey(link)){
                Post post = postMap.get(link);
                post.addTag(p.getTags().get(0));
            }
            else {
                postMap.put(link, p);
            }

        }
        return posts;
    }

    @Override
    public void addNewPostsFromRssLink(RssLink rssLink) throws IOException, ParserConfigurationException, SAXException {
        List<Post> newPosts = Post.parse(rssLink.getRssLink());
        List<Post> oldPosts = postRepository.getPostByRssLink(rssLink);
        List<Post> uniquePost = new ArrayList<>();
        Map<String, Post> mapOldPost = new HashMap<>();
        for(Post post:oldPosts){
            mapOldPost.putIfAbsent(post.getLink(), post);
        }
        for(Post post:newPosts){
            if(!mapOldPost.containsKey(post.getLink())){
                uniquePost.add(post);
            }
        }
        postRepository.save(newPosts, rssLink);
    }
}
