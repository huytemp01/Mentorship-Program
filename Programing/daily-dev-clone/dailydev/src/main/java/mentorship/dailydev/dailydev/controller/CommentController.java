package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.Comment;
import mentorship.dailydev.dailydev.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getCommentFromPost(@PathVariable int postId){
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
