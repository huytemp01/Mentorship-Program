package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Category;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.Source;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface RssService {
    public String addNewSource(String rssXml, Category category, Source source) throws ParserConfigurationException, IOException, SAXException;

    List<RssLink> getAllRssLinks();

    List<RssLink> getRssLink(int limit, int offset);

    int count();

    RssLink getById(int rssId);
}
