package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.SourceDao;
import mentorship.dailydev.dailydev.domain.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SourceRepositoryImpl implements SourceRepository{
    @Autowired
    private SourceDao sourceDao;
    @Override
    public Source save(String domain) {
        sourceDao.insert(domain);
        return sourceDao.getBy(domain);
    }

    @Override
    public boolean isExist(String domain) {
        return false;
    }

    @Override
    public Source getOrSave(String domain) {
        return null;
    }

    @Override
    public Source getBy(String domain) {
        return sourceDao.getBy(domain);
    }
}
