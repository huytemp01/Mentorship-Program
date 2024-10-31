package mentorship.dailydev.dailydev.scheduling;

import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.service.RssProcessService;
import mentorship.dailydev.dailydev.service.RssService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.List;

@Component
public class RssProcess implements Job {
    @Autowired
    private RssProcessService processService;
    @Autowired
    private RssService rssService;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        int limit = dataMap.getInt("limit");
        int offset = dataMap.getInt("offset");
        List<RssLink> rssLinks = rssService.getRssLink(limit,offset);
        for(RssLink rss:rssLinks){
            processService.addNewSchedule(rss);
        }
    }
}
