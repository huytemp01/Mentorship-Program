package mentorship.dailydev.dailydev.domain.dto;

public class UserDTO {
    private int id;
    private String email;
    private String password;
    private String userName;

    public UserDTO(int id, String email, String password, String userName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
