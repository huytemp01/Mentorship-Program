package mentorship.dailydev.dailydev.util;

import java.util.List;

public class Node<Comment> {
    private List<Comment> childNodes;
    private Comment current;

    public Node(Comment current) {
        this.current = current;
    }

    public List<Comment> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<Comment> childNodes) {
        this.childNodes = childNodes;
    }

    public Comment getCurrent() {
        return current;
    }

    public void setCurrent(Comment current) {
        this.current = current;
    }
}
