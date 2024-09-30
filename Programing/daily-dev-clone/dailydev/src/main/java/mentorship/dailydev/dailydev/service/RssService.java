package mentorship.dailydev.dailydev.service;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface RssService {
    public void addNewSource(String rssXml) throws ParserConfigurationException, IOException, SAXException;
}
