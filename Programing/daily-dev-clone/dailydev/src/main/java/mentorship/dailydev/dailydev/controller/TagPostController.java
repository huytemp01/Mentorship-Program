package mentorship.dailydev.dailydev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.service.TagPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TagPostController {
    @Autowired
    private TagPostService tagPostService;

    @GetMapping("/users/{id}/tags/posts")
    public ResponseEntity<List<Post>> getPostsFromTagsFollowedByUser(@PathVariable int id){
        List<Post> posts =  tagPostService.getPostsFromTagsFollowedByUser(id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
