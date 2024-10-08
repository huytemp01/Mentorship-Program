package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.dto.RssLinkDTO;
import mentorship.dailydev.dailydev.util.XmlReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class WebScraperServiceImpl implements WebScraperService{
    @Override
    public List<RssLinkDTO> getAllRssLinkFrom(String url) throws IOException {
        List<RssLinkDTO> links = new ArrayList<>();
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .header("Accept-Language", "*")
                .get();
        Elements elements = doc.getElementsByTag("a");

        for(Element e:elements){
            String link = e.absUrl("href");
            String category = e.ownText();
            if(isRssLink(link)){
                links.add(new RssLinkDTO(link, category));
            }
        }

        return links;
    }

    private boolean isRssLink(String link) {
        try{
            return XmlReader.isRssLink(link);

        }
        catch (ParserConfigurationException | IOException | SAXException e){
            return false;
        }
    }
}
