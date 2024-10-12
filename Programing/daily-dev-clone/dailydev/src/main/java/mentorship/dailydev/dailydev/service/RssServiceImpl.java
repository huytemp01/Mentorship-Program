package mentorship.dailydev.dailydev.service;


import mentorship.dailydev.dailydev.domain.Category;
import mentorship.dailydev.dailydev.domain.Post;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.Source;
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
    public String addNewSource(String rssXml, Category category, Source source) throws ParserConfigurationException, IOException, SAXException {


        if(isRssDuplicated(rssXml)){
            return "rss already existed.";
        }
        else{
            List<Post> posts = Post.parse(rssXml);
            RssLink link = rssRepository.save(rssXml, category.getId(), source.getId());
            postRepository.save(posts, link);
            return "add the source successfully";
        }


    }

    @Override
    public List<RssLink> getAllRssLinks() {
        return rssRepository.getAllRssLinks();
    }

    private boolean isRssDuplicated(String rssXml) {
        return rssRepository.isExist(rssXml);
    }

    public boolean isSourceDuplicated(String domain){
          return sourceRepository.isExist(domain);

    }
}
