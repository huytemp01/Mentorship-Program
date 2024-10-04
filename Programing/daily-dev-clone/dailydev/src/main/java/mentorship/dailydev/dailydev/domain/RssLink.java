package mentorship.dailydev.dailydev.domain;

public class RssLink {
    private int id;
    private String rssLink;

    public RssLink(int id, String rssLink) {
        this.id = id;
        this.rssLink = rssLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRssLink() {
        return rssLink;
    }

    public void setRssLink(String rssLink) {
        this.rssLink = rssLink;
    }
}
