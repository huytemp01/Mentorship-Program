package mentorship.dailydev.dailydev.domain;

public class TagPost {
    private Tag tag;
    private Post post;

    public TagPost(Tag tag, Post post) {
        this.tag = tag;
        this.post = post;
    }

    public Tag getTag() {
        return tag;
    }

    public Post getPost() {
        return post;
    }
}
