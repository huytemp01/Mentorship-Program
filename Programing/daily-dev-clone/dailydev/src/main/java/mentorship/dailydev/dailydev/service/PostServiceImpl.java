package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return posts;
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
}
