package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.Comment;

import java.util.List;

public interface CommentRepository {
    List<Comment> getByPostId(int postId);
}
