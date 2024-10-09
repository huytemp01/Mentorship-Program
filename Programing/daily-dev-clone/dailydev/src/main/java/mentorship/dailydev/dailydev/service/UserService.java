package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.User;
import mentorship.dailydev.dailydev.domain.dto.UserDTO;

public interface UserService {
    public void add(User user);

    boolean isExist(String userName);

    User getByEmail(String email);

    void deleteByEmail(String email);

    String changePassword(int id, String newPassword, String oldPassword);

    boolean login(UserDTO userDto);
}
