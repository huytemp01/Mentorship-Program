package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.RssDao;
import mentorship.dailydev.dailydev.domain.RssLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RssRepositoryImpl implements RssRepository{
    @Autowired
    private RssDao rssDao;
    @Override
    public RssLink save(String rssXml, int categoryId, int sourceId) {
         rssDao.insert(rssXml, categoryId, sourceId);
         return rssDao.getBy(rssXml);
    }

    @Override
    public boolean isExist(String rssXml) {
        return rssDao.isExist(rssXml);
    }
}
