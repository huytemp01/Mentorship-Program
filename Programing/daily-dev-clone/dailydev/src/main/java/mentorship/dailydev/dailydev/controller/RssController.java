package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.service.RssService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
public class RssController {
    private RssService rssService;
//    @PostMapping("rss")
    public String add(@RequestBody String rssXml) throws ParserConfigurationException, IOException, SAXException {
        // Insert links and its category into database.
        rssService.addNewSource(rssXml);
        return rssXml;
    }


}
