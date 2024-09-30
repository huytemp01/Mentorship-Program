package mentorship.dailydev.dailydev.service;


import mentorship.dailydev.dailydev.domain.Article;
import mentorship.dailydev.dailydev.util.XmlReader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class RssServiceImpl implements RssService{
    @Override
    public void addNewSource(String rssXml) throws ParserConfigurationException, IOException, SAXException {

//        List<Article> articles = XmlReader.parseToArticles(rssXml);
    }


}
