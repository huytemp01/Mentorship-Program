package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserPostController {
    @Autowired
    private UserPostService userPostService;

    @GetMapping("user/{id}/rss-posts")
    public List<Post> getPostsFromFollowedTags(@PathVariable int id){
        return userPostService.getPostsFromFollowedTags(id);
    }

}
