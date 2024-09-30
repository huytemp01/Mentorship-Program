package mentorship.dailydev.dailydev.util;

import mentorship.dailydev.dailydev.domain.Article;
import mentorship.dailydev.dailydev.domain.Category;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class XmlReader {
    public static Document readXml(String xmlUrl) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(xmlUrl);
        doc.getDocumentElement().normalize();
        return doc;
    }


}
