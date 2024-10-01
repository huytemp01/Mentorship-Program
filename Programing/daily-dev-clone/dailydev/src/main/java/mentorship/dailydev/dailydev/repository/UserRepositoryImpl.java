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
}
