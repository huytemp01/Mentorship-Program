package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.service.RssService;
import mentorship.dailydev.dailydev.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

@RestController
public class RssController {
    @Autowired
    private RssService rssService;
    @PostMapping("rss")
    public String add(@RequestParam String rssXml) throws ParserConfigurationException, IOException, SAXException {
        // Insert links and its category into database.
        return rssService.addNewSource(rssXml);
    }


}
