package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.UserDaoImpl;
import mentorship.dailydev.dailydev.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private UserDaoImpl userDao;
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void deleteByEmail(String email) {
        userDao.deleteByEmail(email);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void updatePassword(int id, String newPassword) {
         userDao.updatePassword(id, newPassword);
    }

    @Override
    public int isFirstLogin(String email) {
        return userDao.isFirstLogin(email);
    }

    @Override
    public void updateLoginInfo(String email) {
        userDao.updateLoginInfo(email);
    }
}
