package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Process;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.RssLinkNewPostCount;
import mentorship.dailydev.dailydev.repository.RssProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RssProcessServiceImpl implements RssProcessService{
    @Autowired
    private RssProcessRepository rssProcessRepository;

    @Override
    public void addNewSchedule(RssLink rssLink) {
        rssProcessRepository.addNewProcess(rssLink);
    }

    @Override
    public int countNotStartProcess() {
        return rssProcessRepository.countNotStartProcess();
    }

    @Override
    public List<Process> getProcessToday(int offset, int limit) {
        return rssProcessRepository.getProcessNotStartToday(offset, limit);
    }

    @Override
    public void updateInfoProcess(int id, int postCount) {
         rssProcessRepository.updateProcessInfo(id, postCount);
    }
}
