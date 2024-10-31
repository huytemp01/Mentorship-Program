package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.Category;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.Source;
import mentorship.dailydev.dailydev.domain.dto.RssLinkDTO;
import mentorship.dailydev.dailydev.service.CategoryService;
import mentorship.dailydev.dailydev.service.RssService;
import mentorship.dailydev.dailydev.service.SourceService;
import mentorship.dailydev.dailydev.service.WebScraperService;
import mentorship.dailydev.dailydev.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
public class WebScraperController {
    @Autowired
    private WebScraperService webScraperService;
    @Autowired
    private RssService rssService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/posts/rss")
    public String addRssLinkFromWebsite(@RequestParam String url) throws IOException, ParserConfigurationException, SAXException {
        List<RssLinkDTO> links = webScraperService.getAllRssLinkFrom(url);
        for(RssLinkDTO rssXml: links){
            String domain = URL.getDomainName(rssXml.getLink());
            Source source = sourceService.getOrSave(domain);
            Category cate = categoryService.getOrSave(rssXml.getCategory_name());
            rssService.addNewSource(rssXml.getLink(), cate, source);
        }
        return "Add successfully";
    }

    @GetMapping("rss")
    public List<RssLinkDTO> extractRssLinkFromWebsite(@RequestParam String url) throws IOException {
        List<RssLinkDTO> links = webScraperService.getAllRssLinkFrom(url);
        return links;
    }
}
