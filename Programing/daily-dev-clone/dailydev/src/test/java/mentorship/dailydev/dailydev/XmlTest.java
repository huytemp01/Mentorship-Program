package mentorship.dailydev.dailydev;

import mentorship.dailydev.dailydev.domain.Article;
import mentorship.dailydev.dailydev.domain.Category;
import mentorship.dailydev.dailydev.util.XmlReader;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class XmlTest {
    @Test
    public void Test_get_Item_tag() throws ParserConfigurationException, IOException, SAXException {
        //Arrange
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/test/java/mentorship/dailydev/dailydev/Americas.xml"));
        //Act
        NodeList list = doc.getElementsByTagName("item");
        //Assert
        Assert.assertEquals(20,list.getLength());
    }

    @Test
    public void Test_get_title_from_first_item() throws ParserConfigurationException, IOException, SAXException {
        //Arrange
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/test/java/mentorship/dailydev/dailydev/Americas.xml"));
        NodeList list = doc.getElementsByTagName("item");
        //Act
        Node first = list.item(0);
        NodeList childList = first.getChildNodes();

    }

    @Test
    public void Test_get_title_from_Item() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/test/java/mentorship/dailydev/dailydev/Americas.xml"));
        NodeList list = doc.getElementsByTagName("item");
        Node first = list.item(0);
        //Act
        String title = Article.getTitle(first);
        //Assert
        String expected = "Studying at an English-Speaking University? In Quebec, That May Cost Extra.";
        Assert.assertEquals(expected, title);
    }

    @Test
    public void Test_get_link_from_Item() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/test/java/mentorship/dailydev/dailydev/Americas.xml"));
        NodeList list = doc.getElementsByTagName("item");
        Node first = list.item(0);
        //Act
        String title = Article.getLink(first);
        //Assert
        String expected = "https://www.nytimes.com/2024/09/29/world/canada/quebec-mcgill-concordia-tuition.html";
        Assert.assertEquals(expected, title);
    }

    @Test
    public void Test_get_description_from_item() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/test/java/mentorship/dailydev/dailydev/Americas.xml"));
        NodeList list = doc.getElementsByTagName("item");
        Node first = list.item(0);
        //Act
        String title = Article.getDescription(first);
        //Assert
        String expected = "Quebec says a new policy to charge some students higher tuition at top universities in Montreal is needed to preserve the province’s French identity.";
        Assert.assertEquals(expected, title);
    }

    @Test
    public void Test_get_public_date_from_item() throws IOException, SAXException, ParserConfigurationException {
        //Arrange
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/test/java/mentorship/dailydev/dailydev/Americas.xml"));
        NodeList list = doc.getElementsByTagName("item");
        Node first = list.item(0);
        //Act
        LocalDateTime publicDate = Article.getPublicDate(first);
        //Assert
        String dateTimeString = "Sun, 29 Sep 2024 18:50:01 +0000";
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z");
        LocalDateTime expected = LocalDateTime.parse(dateTimeString, dateTimeFormat);

        Assert.assertEquals(expected, publicDate);
    }

    @Test
    public void Test_get_creator_from_item() throws IOException, SAXException, ParserConfigurationException {
        //Arrange
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/test/java/mentorship/dailydev/dailydev/Americas.xml"));
        NodeList list = doc.getElementsByTagName("item");
        Node first = list.item(0);
        //Act
        String creator = Article.getCreator(first);
        //Assert
        String expected = "Vjosa Isai and Nasuna Stuart-Ulin";

        Assert.assertEquals(expected, creator);
    }

    @Test
    public void Test_get_categories_from_item() throws IOException, SAXException, ParserConfigurationException {
        //Arrange
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/test/java/mentorship/dailydev/dailydev/Americas.xml"));
        NodeList list = doc.getElementsByTagName("item");
        Node first = list.item(0);
        //Act
        List<Category> categoryList = Article.getCategories(first);
        //Assert
        int expected = 10;
        Assert.assertEquals(expected, categoryList.size());
    }

    @Test
    public void Test_convert_Items_to_Article() throws ParserConfigurationException, IOException, SAXException {
        //Arrange
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/test/java/mentorship/dailydev/dailydev/Americas.xml"));
        NodeList list = doc.getElementsByTagName("item");
        //Act
        List<Article> articleList = Article.parse(list);
        //Assert
        int expected = 20;
        Assert.assertEquals(expected, articleList.size());
    }
}
