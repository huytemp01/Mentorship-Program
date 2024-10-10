package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping("/source/posts")
    public ResponseEntity<List<Post>> getAllPostsFromSource(@RequestParam String domain){
        List<Post> posts = postService.getPostsFromSource(domain);
        return new  ResponseEntity<>(posts, HttpStatus.OK);
    }
}
