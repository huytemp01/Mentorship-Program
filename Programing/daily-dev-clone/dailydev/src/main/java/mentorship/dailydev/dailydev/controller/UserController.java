package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.User;
import mentorship.dailydev.dailydev.domain.dto.UserDTO;
import mentorship.dailydev.dailydev.service.UserService;
import mentorship.dailydev.dailydev.service.UserTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserTagService userTagService;
    @PostMapping("user/register")
    public String addNewUser(@RequestBody UserDTO userDto){
        if(userService.isExist(userDto.getEmail())){
            return "Email already existed";
        }
        User user = new User(userDto.getId(), userDto.getEmail(), userDto.getPassword(), userDto.getUserName());
        userService.add(user);
        return "Success";
    }

    @PostMapping("user/login")
    public ResponseEntity<Void> login(@RequestBody UserDTO userDto){
        if(userService.login(userDto)){
            boolean isFirstLogin = userService.isFirstLogin(userDto.getEmail());
            User user = userService.getByEmail(userDto.getEmail());
            if(isFirstLogin){
                userService.updateLoginInfo(user.getEmail());
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(URI.create("/tags"));
                return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
            }
            else if(userTagService.haveFollowAnyTags(user.getId())){
                // hien thi cac post co tag ma user follow
                System.out.println("co tag");
            }
            else {
                // hien thi top 10 bai viet co nhieu luong view nhat
                System.out.println("khong co");
            }
        }
        return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
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
