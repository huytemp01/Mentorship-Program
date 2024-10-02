package mentorship.dailydev.dailydev.service;


import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.repository.PostRepository;
import mentorship.dailydev.dailydev.repository.RssRepository;
import mentorship.dailydev.dailydev.repository.SourceRepository;
import mentorship.dailydev.dailydev.util.URL;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
@Service
public class RssServiceImpl implements RssService{
    private RssRepository rssRepository;
    private PostRepository postRepository;

    private SourceRepository sourceRepository;
    @Override
    public void addNewSource(String rssXml) throws ParserConfigurationException, IOException, SAXException {
        List<Post> posts = Post.parse(rssXml);
        String domain = URL.getDomainName(rssXml);
        sourceRepository.save(domain);
        rssRepository.save(rssXml);
        postRepository.save(posts);
    }
}
