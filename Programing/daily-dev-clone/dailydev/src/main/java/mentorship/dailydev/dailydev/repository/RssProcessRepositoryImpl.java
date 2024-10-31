package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.RssProcessDao;
import mentorship.dailydev.dailydev.domain.Process;
import mentorship.dailydev.dailydev.domain.RssLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RssProcessRepositoryImpl implements  RssProcessRepository{
    @Autowired
    private RssProcessDao rssProcessDao;
    @Override
    public void addNewProcess(RssLink rssLink) {
        rssProcessDao.insert(rssLink);
    }

    @Override
    public int countNotStartProcess() {
        return rssProcessDao.countNotStartProcess();
    }

    @Override
    public List<Process> getProcessNotStartToday(int offset, int limit) {
        return rssProcessDao.getProcessNotStartToday(offset,limit);
    }

    @Override
    public void updateProcessInfo(int id, int postCount) {
        rssProcessDao.updateProcessInfo(id, postCount);
    }
}
