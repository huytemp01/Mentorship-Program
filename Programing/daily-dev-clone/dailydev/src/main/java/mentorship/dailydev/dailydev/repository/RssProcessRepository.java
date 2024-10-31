package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.Process;
import mentorship.dailydev.dailydev.domain.RssLink;

import java.util.List;

public interface RssProcessRepository {
    void addNewProcess(RssLink rssLink);

    int countNotStartProcess();

    List<Process> getProcessNotStartToday(int offset, int limit);

    void updateProcessInfo(int id, int postCount);
}
