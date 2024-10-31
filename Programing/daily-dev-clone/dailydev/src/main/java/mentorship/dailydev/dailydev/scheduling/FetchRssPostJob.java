package mentorship.dailydev.dailydev.scheduling;

import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.RssLinkNewPostCount;
import mentorship.dailydev.dailydev.service.PostService;
import mentorship.dailydev.dailydev.service.RssProcessService;
import mentorship.dailydev.dailydev.service.RssService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Component
public class FetchRssPostJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        PostService postService = (PostService) dataMap.get("postService");
        RssService rssService = (RssService) dataMap.get("rssService");
        RssProcessService rssProcessServiceJob = (RssProcessService) dataMap.get("processService");
        int rssId = dataMap.getInt("rssId");
        int id = dataMap.getInt("id");
        RssLink rssLink = rssService.getById(rssId);
        int countUpdate = 0;
        try {
            countUpdate = postService.addNewPostsFromRssLink(rssLink);
            RssLinkNewPostCount postCount = new RssLinkNewPostCount(rssLink,countUpdate);
            rssProcessServiceJob.updateInfoProcess(id, postCount.getCountUpdate());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }

//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        // get post from rssLink.
//        JobKey key = context.getJobDetail().getKey();
//        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
//        String link = dataMap.getString("link");
//        int id = dataMap.getInt("id");
//        RssLink rssLink = new RssLink(id,link);
//        try {
//            System.out.println("Fetch: " + link);
//            postService.addNewPostsFromRssLink(rssLink);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ParserConfigurationException e) {
//            throw new RuntimeException(e);
//        } catch (SAXException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
