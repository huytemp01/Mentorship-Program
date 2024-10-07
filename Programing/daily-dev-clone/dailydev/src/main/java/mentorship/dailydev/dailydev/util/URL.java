package mentorship.dailydev.dailydev.util;

public class URL {
    public static String getDomainName(String url){
        String domainName =  url.replaceAll("http(s)?://|www\\.|/.*", "");
        return domainName;
    }
}
