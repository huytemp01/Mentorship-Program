package mentorship.dailydev.dailydev.scheduling;

import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.service.PostService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
@Component
public class FetchRss implements Job {
    @Autowired
    private PostService postService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // get post from rssLink.
        JobKey key = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String link = dataMap.getString("link");
        int id = dataMap.getInt("id");
        RssLink rssLink = new RssLink(id,link);
        try {
            System.out.println("Fetch: " + link);
            postService.addNewPostsFromRssLink(rssLink);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

}
