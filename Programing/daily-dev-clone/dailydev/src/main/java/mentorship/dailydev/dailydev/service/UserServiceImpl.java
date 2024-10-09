package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.User;
import mentorship.dailydev.dailydev.domain.dto.UserDTO;
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

    @Override
    public boolean isExist(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            return false;
        }
        return true;
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public String changePassword(int id, String newPassword, String oldPassword) {
        User user = userRepository.getById(id);
        if(user == null){
            return "User don't exist";
        }
        if(!user.getPassword().equals(oldPassword)){
            return "Current password don't  match";
        }

        userRepository.updatePassword(id, newPassword);
        return "success";
    }

    @Override
    public boolean login(UserDTO userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());
        return isPasswordMatching(user.getPassword(), userDto.getPassword());
    }

    private boolean isPasswordMatching(String password, String password1) {
        return password.equals(password1);
    }
}
