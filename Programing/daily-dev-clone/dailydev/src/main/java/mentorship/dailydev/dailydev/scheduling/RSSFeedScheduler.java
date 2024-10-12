package mentorship.dailydev.dailydev.scheduling;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.service.PostService;
import mentorship.dailydev.dailydev.service.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//https://dzone.com/articles/optimizing-java-applications-parallel-processing-a
@Component
public class RSSFeedScheduler {
    @Autowired
    private RssService rssService;
    @Autowired
    private PostService postService;
    @Scheduled(fixedRate = 60000)
    public void getPost(){
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        List<RssLink> rssLinks = rssService.getAllRssLinks();
        for(RssLink link:rssLinks){
            Runnable task = ()->{
                try {
                    postService.addNewPostsFromRssLink(link);
                    System.out.println("Run:" + link.getRssLink());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParserConfigurationException e) {
                    throw new RuntimeException(e);
                } catch (SAXException e) {
                    throw new RuntimeException(e);
                }
            };

            executorService.execute(task);
        }

        System.out.println("===============");

    }
}
