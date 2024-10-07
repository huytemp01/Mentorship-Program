package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.Category;
import mentorship.dailydev.dailydev.domain.Source;
import mentorship.dailydev.dailydev.service.CategoryService;
import mentorship.dailydev.dailydev.service.RssService;
import mentorship.dailydev.dailydev.service.SourceService;
import mentorship.dailydev.dailydev.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
public class RssController {
    @Autowired
    private RssService rssService;
    @Autowired
    private SourceService sourceService;

    @Autowired
    private CategoryService categoryService;
    @PostMapping("rss")
    public String add(@RequestParam String rssXml,@RequestParam String category) throws ParserConfigurationException, IOException, SAXException {
        String domain = URL.getDomainName(rssXml);
        Source source = sourceService.getOrSave(domain);
        Category cate = categoryService.getOrSave(category);
        String message = rssService.addNewSource(rssXml, cate, source);
        return message ;
    }


}
