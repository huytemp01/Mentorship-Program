package mentorship.dailydev.dailydev.repository;

public interface RssRepository {
    void save(String rssXml);

    boolean isExist(String rssXml);
}
