package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.RssDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RssRepositoryImpl implements RssRepository{
    @Autowired
    private RssDao rssDao;
    @Override
    public void save(String rssXml) {
        rssDao.insert(rssXml);
    }

    @Override
    public boolean isExist(String rssXml) {
        return rssDao.isExist(rssXml);
    }
}
