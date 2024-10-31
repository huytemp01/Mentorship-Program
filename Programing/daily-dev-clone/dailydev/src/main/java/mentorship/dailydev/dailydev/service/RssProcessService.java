package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Process;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.RssLinkNewPostCount;

import java.util.List;

public interface RssProcessService {
    void addNewSchedule(RssLink rssLink);

    int countNotStartProcess();

    List<Process> getProcessToday(int offset, int limit);

    void updateInfoProcess(int id, int postCount);
}
