package mentorship.dailydev.dailydev.domain;

public class RssLinkNewPostCount {
    private RssLink rssLink;
    private int countUpdate;

    public RssLinkNewPostCount(RssLink rssLink, int countUpdate) {
        this.rssLink = rssLink;
        this.countUpdate = countUpdate;
    }

    public RssLink getRssLink() {
        return rssLink;
    }

    public void setRssLink(RssLink rssLink) {
        this.rssLink = rssLink;
    }

    public int getCountUpdate() {
        return countUpdate;
    }

    public void setCountUpdate(int countUpdate) {
        this.countUpdate = countUpdate;
    }
}
