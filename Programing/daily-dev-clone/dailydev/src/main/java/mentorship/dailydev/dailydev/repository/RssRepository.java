package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.RssLink;

public interface RssRepository {
    RssLink save(String rssXml, int cateId, int sourceId);

    boolean isExist(String rssXml);
}
