package mentorship.dailydev.dailydev.service;


import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.repository.PostRepository;
import mentorship.dailydev.dailydev.repository.RssRepository;
import mentorship.dailydev.dailydev.repository.SourceRepository;
import mentorship.dailydev.dailydev.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
@Service
public class RssServiceImpl implements RssService{
    @Autowired
    private RssRepository rssRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private SourceRepository sourceRepository;
    @Override
    public String addNewSource(String rssXml) throws ParserConfigurationException, IOException, SAXException {
        List<Post> posts = Post.parse(rssXml);
        String domain = URL.getDomainName(rssXml);
        if(!isSourceDuplicated(domain)){
            sourceRepository.save(domain);
        }

        if(isRssDuplicated(rssXml)){
            return "rss already existed.";
        }
        else{
            rssRepository.save(rssXml);
        }
        postRepository.save(posts);
        return "add the source successfully";
    }

    private boolean isRssDuplicated(String rssXml) {
        return rssRepository.isExist(rssXml);
    }

    public boolean isSourceDuplicated(String domain){
          return sourceRepository.isExist(domain);

    }
}
