package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.User;
import mentorship.dailydev.dailydev.domain.dto.UserDTO;
import mentorship.dailydev.dailydev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("user/new")
    public String addNewUser(@RequestBody UserDTO userDto){
        User user = new User(userDto.getId(), userDto.getEmail(), userDto.getPassword(), userDto.getUserName());
        userService.add(user);
        return "success";
    }
}
