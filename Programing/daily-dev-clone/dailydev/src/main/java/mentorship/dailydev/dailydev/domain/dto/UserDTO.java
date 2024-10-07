package mentorship.dailydev.dailydev.domain.dto;

public class UserDTO {
    private int id;
    private String email;
    private String password;
    private String userName;

    private String oldPassword;
    private String newPassword;

    public UserDTO(){}

    public UserDTO(int id, String email, String password, String userName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public UserDTO(int id, String email, String userName, String oldPassword, String newPassword) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
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

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
