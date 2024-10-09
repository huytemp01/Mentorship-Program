package mentorship.dailydev.dailydev.domain.dto;

public class TagDTO {
    private int id;
    private String tagName;

    public TagDTO(int id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }

    public int getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

}
