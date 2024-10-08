package mentorship.dailydev.dailydev.util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlReader {
    public static Document readXml(String xmlUrl) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(xmlUrl);
        doc.getDocumentElement().normalize();
        return doc;
    }

    public static boolean isRssLink(String url) throws ParserConfigurationException, IOException, SAXException {
        Document doc = readXml(url);
        NodeList list = doc.getElementsByTagName("rss");
        if(list.getLength() == 0){
            return false;
        }
        return true;
    }


}
