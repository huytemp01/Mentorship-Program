package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.User;

public interface UserRepository {
    public void save(User user);

    User findByEmail(String email);

    void deleteByEmail(String email);

    User getById(int id);

    void updatePassword(int id, String newPassword);

    int isFirstLogin(String email);

    void updateLoginInfo(String email);
}
