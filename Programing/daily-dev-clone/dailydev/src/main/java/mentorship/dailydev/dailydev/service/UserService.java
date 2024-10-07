package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.User;

public interface UserService {
    public void add(User user);

    boolean isExist(String userName);

    User getByEmail(String email);

    void deleteByEmail(String email);

    String changePassword(int id, String newPassword, String oldPassword);
}
