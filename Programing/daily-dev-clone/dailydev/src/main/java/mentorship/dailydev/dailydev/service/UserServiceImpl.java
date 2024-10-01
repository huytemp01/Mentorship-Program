package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.User;
import mentorship.dailydev.dailydev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void add(User user) {
        userRepository.save(user);
    }
}
