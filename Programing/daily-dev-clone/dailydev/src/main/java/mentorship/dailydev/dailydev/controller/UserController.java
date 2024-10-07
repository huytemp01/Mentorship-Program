package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.User;
import mentorship.dailydev.dailydev.domain.dto.UserDTO;
import mentorship.dailydev.dailydev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("user")
    public String addNewUser(@RequestBody UserDTO userDto){
        if(userService.isExist(userDto.getEmail())){
            return "Email already existed";
        }
        User user = new User(userDto.getId(), userDto.getEmail(), userDto.getPassword(), userDto.getUserName());
        userService.add(user);
        return "Success";
    }

    @GetMapping("user/{email}")
    public User getUserByEmail(@PathVariable String email){
        User user = userService.getByEmail(email);
        return user;
    }

    @DeleteMapping("user/{email}")
    public String deleteByEmail(@PathVariable String email){
        userService.deleteByEmail(email);
        return "success";
    }

    @PutMapping("user/password")
    public String changePassword(@RequestBody UserDTO userDTO){
        int id = userDTO.getId();
        String newPassword = userDTO.getNewPassword();
        String oldPassword = userDTO.getOldPassword();
        if(User.isPasswordValid(newPassword)){
            return userService.changePassword(id, newPassword, oldPassword);

        }

        return "new password is not valid";
    }


}
