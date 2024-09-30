package mentorship.dailydev.dailydev.domain;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Article {
    private int id;
    private String title;
    private String link;
    private String description;
    private String creatorName;
    private LocalDateTime publicDateTime;
    private List<Category> categories;

    public Article(){}

    public Article(String title, String link, String description, String creatorName, LocalDateTime publicDateTime, List<Category> categories) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.creatorName = creatorName;
        this.publicDateTime = publicDateTime;
        this.categories = categories;
    }


    public static String getTitle(Node item) {
        NodeList childNodes = item.getChildNodes();
        Node current;
        for(int i = 0; i<childNodes.getLength(); i++){
            current = childNodes.item(i);
            if(current.getNodeType() == Node.ELEMENT_NODE && current.getNodeName().equals("title")){
                return current.getTextContent();
            }
        }
        return "";
    }

    public static String getLink(Node item) {
        NodeList childNodes = item.getChildNodes();
        Node current;
        for(int i = 0; i<childNodes.getLength(); i++){
            current = childNodes.item(i);
            if(current.getNodeType() == Node.ELEMENT_NODE && current.getNodeName().equals("link")){
                return current.getTextContent();
            }
        }
        return "";
    }

    public static String getDescription(Node item){
        NodeList childNodes = item.getChildNodes();
        Node current;
        for(int i = 0; i<childNodes.getLength(); i++){
            current = childNodes.item(i);
            if(current.getNodeType() == Node.ELEMENT_NODE && current.getNodeName().equals("description")){
                return current.getTextContent();
            }
        }
        return "";
    }

    public static LocalDateTime getPublicDate(Node item){
        NodeList childNodes = item.getChildNodes();
        Node current;
        for(int i = 0; i<childNodes.getLength(); i++){
            current = childNodes.item(i);
            if(current.getNodeType() == Node.ELEMENT_NODE && current.getNodeName().equals("pubDate")){
                String dateTimestring =  current.getTextContent();
                DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z");
                LocalDateTime dateTime = LocalDateTime.parse(dateTimestring, dateTimeFormat);
                return dateTime;
            }
        }
        return null;
    }

    public static String getCreator(Node item){
        NodeList childNodes = item.getChildNodes();
        Node current;
        for(int i = 0; i<childNodes.getLength(); i++){
            current = childNodes.item(i);
            if(current.getNodeType() == Node.ELEMENT_NODE && current.getNodeName().equals("dc:creator")){
                return current.getTextContent();
            }
        }
        return "";
    }

    public static List<Category> getCategories(Node item){
        List<Category> categories = new ArrayList<>();
        NodeList childNodes = item.getChildNodes();
        Node current;
        for(int i = 0; i<childNodes.getLength(); i++){
            current = childNodes.item(i);
            if(current.getNodeType() == Node.ELEMENT_NODE && current.getNodeName().equals("category")){
                Category category = new Category(current.getTextContent());
                categories.add(category);
            }
        }
        return categories;
    }

    public static List<Article> parse(NodeList items) {
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i<items.getLength(); i++){
            Article a = Article.parse(items.item(i));
            articles.add(a);
        }
        return articles;
    }

    public static Article parse(Node item){
        String title = Article.getTitle(item);
        String link = Article.getLink(item);
        String description = Article.getDescription(item);
        LocalDateTime pubDate = Article.getPublicDate(item);
        String creator = Article.getCreator(item);
        List<Category> categories = Article.getCategories(item);

        return new Article(title,link,description, creator, pubDate, categories);
    }
}
