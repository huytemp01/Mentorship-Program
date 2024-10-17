package mentorship.dailydev.dailydev.util;

import mentorship.dailydev.dailydev.domain.Comment;

import java.util.ArrayList;
import java.util.List;

public class Tree{
    private List<Node<Comment>> comments = new ArrayList<>();

    public List<Node<Comment>> getComments() {
        return comments;
    }

    public void setComments(List<Node<Comment>> comments) {
        this.comments = comments;
    }

}
