package mentorship.dailydev.dailydev.domain;

public class Source {
    private int id;
    private String domain_name;

    public Source(int id, String domain_name) {
        this.id = id;
        this.domain_name = domain_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }
}
