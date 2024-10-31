package mentorship.dailydev.dailydev.scheduling;

import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.service.RssProcessService;
import mentorship.dailydev.dailydev.service.RssService;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.List;
@Component
public class ProcessJob extends QuartzJobBean  {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        int limit = dataMap.getInt("limit");
        int offset = dataMap.getInt("offset");
        RssService rssService = (RssService) dataMap.get("rssService");
        RssProcessService processService = (RssProcessService) dataMap.get("processService");
        List<RssLink> rssLinks = rssService.getRssLink(limit,offset);
        for(RssLink rss:rssLinks){
            processService.addNewSchedule(rss);
        }
    }

}
