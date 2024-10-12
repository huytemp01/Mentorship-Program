package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.RssLink;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface PostService {
    List<Post> getPostsFromSource(String domain);

    List<Post> getTheMostViews();

    void addNewPostsFromRssLink(RssLink rssLink) throws IOException, ParserConfigurationException, SAXException;
}
