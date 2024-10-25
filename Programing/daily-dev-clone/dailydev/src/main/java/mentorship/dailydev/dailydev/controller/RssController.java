package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.Category;
import mentorship.dailydev.dailydev.domain.RssLinkNewPostCount;
import mentorship.dailydev.dailydev.domain.Source;
import mentorship.dailydev.dailydev.service.CategoryService;
import mentorship.dailydev.dailydev.service.FetchRssService;
import mentorship.dailydev.dailydev.service.RssService;
import mentorship.dailydev.dailydev.service.SourceService;
import mentorship.dailydev.dailydev.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
public class RssController {
    @Autowired
    private RssService rssService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FetchRssService fetchRssService;
    @PostMapping("rss")
    public String add(@RequestParam String url,@RequestParam String category) throws ParserConfigurationException, IOException, SAXException {
        String domain = URL.getDomainName(url);
        Source source = sourceService.getOrSave(domain);
        Category cate = categoryService.getOrSave(category);
        String message = rssService.addNewSource(url, cate, source);
        return message ;
    }

    @PostMapping("test")
    public ResponseEntity<List<RssLinkNewPostCount>> test() throws ParserConfigurationException, IOException, SAXException {
        List<RssLinkNewPostCount> countUpdates=  fetchRssService.updateNewPosts();
        return new ResponseEntity<>(countUpdates, HttpStatus.OK);
    }


}
