package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.domain.TagPost;
import mentorship.dailydev.dailydev.repository.TagPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TagPostServiceImpl implements TagPostService{
    @Autowired
    private TagPostRepository tagPostRepository;
    @Override
    public List<Post> getPostsFromTagsFollowedByUser(int userId) {
        HashMap<Post, List<Tag>> map = new HashMap<>();
        List<TagPost> list = tagPostRepository.getPostsForUser(userId);
        for(TagPost tp: list){
            if(!map.containsKey(tp.getPost())){
                List<Tag> tags = new ArrayList<>();
                tags.add(tp.getTag());
                map.put(tp.getPost(), tags);
            }
            else {
                map.get(tp.getPost()).add(tp.getTag());
            }

        }
        List<Post> posts = new ArrayList<>();
        for(Post p:map.keySet()){
            p.setTags(map.get(p));
            posts.add(p);
        }
        return posts;
    }
}
