package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.SourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SourceRepositoryImpl implements SourceRepository{
    @Autowired
    private SourceDao sourceDao;
    @Override
    public void save(String domain) {
        sourceDao.insert(domain);
    }
}
