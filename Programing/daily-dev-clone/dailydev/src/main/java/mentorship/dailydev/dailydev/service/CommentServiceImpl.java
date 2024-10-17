package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Comment;
import mentorship.dailydev.dailydev.repository.CommentRepository;
import mentorship.dailydev.dailydev.util.Node;
import mentorship.dailydev.dailydev.util.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<Comment> getCommentsByPostId(int postId) {
        List<Comment> comments = commentRepository.getByPostId(postId);
        Tree tree = new Tree();
        List<Comment> topComment = comments.stream().filter(c -> c.getRepliedTo() == 0).collect(Collectors.toList());
        List<Comment> repliedComments = comments.stream().filter(c -> c.getRepliedTo()>0).collect(Collectors.toList());
        List<Node<Comment>> nodes = new ArrayList<>();
        for(Comment c:topComment){
            Node<Comment> node = new Node<>(c);
            nodes.add(node);
        }

        for(Comment c:repliedComments){
            //
        }

        return comments;
    }
}
