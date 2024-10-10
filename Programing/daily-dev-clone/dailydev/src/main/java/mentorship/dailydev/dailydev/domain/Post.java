package mentorship.dailydev.dailydev.domain;

import mentorship.dailydev.dailydev.util.XmlReader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Post {
    private int id;
    private String title;
    private String link;
    private String description;
    private String creatorName;
    private LocalDateTime publicDateTime;
    private List<Category> categories;

    private List<Tag> tags = new ArrayList<>();

    public Post(){}

    public Post(int id, String title, String link, String description, String creatorName, LocalDateTime publicDateTime, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.creatorName = creatorName;
        this.publicDateTime = publicDateTime;
        this.categories = categories;
    }

    public Post(String title, String link, String description, String creatorName, LocalDateTime publicDateTime, List<Category> categories) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.creatorName = creatorName;
        this.publicDateTime = publicDateTime;
        this.categories = categories;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public LocalDateTime getPublicDateTime() {
        return publicDateTime;
    }

    public void setPublicDateTime(LocalDateTime publicDateTime) {
        this.publicDateTime = publicDateTime;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && Objects.equals(link, post.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, link);
    }

    ///////////////////////////////////
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
                DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss ZZZ");
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

    public static List<Post> parse(NodeList items) {
        List<Post> posts = new ArrayList<>();
        for(int i = 0; i<items.getLength(); i++){
            Post a = Post.parse(items.item(i));
            posts.add(a);
        }
        return posts;
    }

    public static Post parse(Node item){
        String title = Post.getTitle(item);
        String link = Post.getLink(item);
        String description = Post.getDescription(item);
        LocalDateTime pubDate = Post.getPublicDate(item);
        String creator = Post.getCreator(item);
        List<Category> categories = Post.getCategories(item);

        return new Post(title,link,description, creator, pubDate, categories);
    }

    public static List<Post> parse(String xmlUrl) throws IOException, SAXException, ParserConfigurationException {
//        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//        Document doc = builder.parse(xmlUrl);
//        doc.getDocumentElement().normalize();
        Document doc = XmlReader.readXml(xmlUrl);
        NodeList list = doc.getElementsByTagName("item");
        return Post.parse(list);
    }
}
