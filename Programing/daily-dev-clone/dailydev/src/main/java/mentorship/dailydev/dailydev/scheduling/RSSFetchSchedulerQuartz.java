package mentorship.dailydev.dailydev.scheduling;

import mentorship.dailydev.dailydev.domain.Process;
import mentorship.dailydev.dailydev.service.PostService;
import mentorship.dailydev.dailydev.service.RssProcessService;
import mentorship.dailydev.dailydev.service.RssService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Component
public class RSSFetchSchedulerQuartz {
    @Autowired
    private RssService rssService;
    @Autowired
    private RssProcessService processService;

    @Autowired
    private PostService postService;
    @Scheduled(fixedRate = 3600000)
    public void run() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        JobDataMap rssServiceJob = new JobDataMap();
        rssServiceJob.put("rssService", rssService);

        JobDataMap rssProcessServiceJob = new JobDataMap();
        rssServiceJob.put("processService", processService);

        JobDataMap postServiceJobData = new JobDataMap();
        postServiceJobData.put("postService", postService);

        int totalRssNumber = rssService.count();
        int offset = 0;
        int limit = 100;
        for(int i = 0; i < totalRssNumber; i+= limit){
            JobDetail jobDetail = newJob(ProcessJob.class)
                    .withIdentity("process" + i,"group" + i)
                    .usingJobData("limit" , limit)
                    .usingJobData("offset", offset)
                    .usingJobData(rssServiceJob)
                    .usingJobData(rssProcessServiceJob)
                    .build();
            offset += limit;

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger" + i, "group" +i)
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(20)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
        }

        int totalNotStartProcess = processService.countNotStartProcess();
        for(int i = 0; i < totalNotStartProcess; i+= limit){
            List<Process> processList = processService.getProcessToday(offset,limit);
            offset+= limit;
            for(Process p:processList){
                JobDetail FetchRssPostJob = newJob(FetchRssPostJob.class)
                        .withIdentity("rss" + p.getId(),"group" + i)
                        .usingJobData("rssId", p.getRssId())
                        .usingJobData("id", p.getId())
                        .usingJobData(postServiceJobData)
                        .usingJobData(rssServiceJob)
                        .usingJobData(rssProcessServiceJob)
                        .build();

                Trigger trigger = TriggerBuilder.newTrigger()
                        .withIdentity("triggerForFetchRss" + p.getId(), "groupForFetchRss" +p.getId())
                        .startNow()
                        .withSchedule(simpleSchedule()
                                .withIntervalInMinutes(5)
                                .repeatForever())
                        .build();

                scheduler.scheduleJob(FetchRssPostJob, trigger);
            }
        }

//        scheduler.shutdown(true);

    }
}
