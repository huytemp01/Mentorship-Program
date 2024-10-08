package mentorship.dailydev.dailydev.domain.dto;

public class RssLinkDTO {
    private String link;
    private String category_name;

    public RssLinkDTO(String link, String category_name) {
        this.link = link;
        this.category_name = category_name;
    }

    public String getLink() {
        return link;
    }

    public String getCategory_name() {
        return category_name;
    }
}
