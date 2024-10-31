package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.RssLink;

import java.util.List;

public interface RssRepository {
    RssLink save(String rssXml, int cateId, int sourceId);

    boolean isExist(String rssXml);

    List<RssLink> getAllRssLinks();

    List<RssLink> getRssLinks(int limit, int offset);

    int count();

    RssLink getById(int rssId);
}
