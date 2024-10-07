package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.Source;

public interface SourceRepository {
    Source save(String domain);

    boolean isExist(String domain);

    Source getOrSave(String domain);

    Source getBy(String domain);
}
