package mentorship.dailydev.dailydev.repository;

public interface SourceRepository {
    void save(String domain);

    boolean isExist(String domain);
}
