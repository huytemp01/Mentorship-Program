package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByPostId(int postId);
}
