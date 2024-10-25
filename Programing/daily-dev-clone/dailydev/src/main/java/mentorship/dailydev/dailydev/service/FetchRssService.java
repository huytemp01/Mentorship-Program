package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.RssLinkNewPostCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FetchRssService {
    @Autowired
    private RssService rssService;
    @Autowired
    private PostService postService;
    @Autowired
    private SourceService sourceService;

    public List<RssLinkNewPostCount> updateNewPosts() throws IOException, ParserConfigurationException, SAXException {
        List<RssLink> rssLinks = rssService.getAllRssLinks();
        List<RssLinkNewPostCount> list = new ArrayList<>();
        for(RssLink link:rssLinks){
            int countUpdate = postService.addNewPostsFromRssLink(link);
            RssLinkNewPostCount postCount = new RssLinkNewPostCount(link,countUpdate);
            list.add(postCount);
        }
        return list;
    }
}
