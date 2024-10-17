package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.CommentDao;
import mentorship.dailydev.dailydev.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    private CommentDao commentDao;
    @Override
    public List<Comment> getByPostId(int postId) {
        return commentDao.getByPostId(postId);
    }
}
