package mentorship.dailydev.dailydev.domain;

public class Comment {
    private int id;
    private String content;
    private String image;
    private String link;

    private User user;
    private int repliedTo;

    public Comment(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Comment(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRepliedTo() {
        return repliedTo;
    }

    public void setRepliedTo(int repliedTo) {
        this.repliedTo = repliedTo;
    }
}
