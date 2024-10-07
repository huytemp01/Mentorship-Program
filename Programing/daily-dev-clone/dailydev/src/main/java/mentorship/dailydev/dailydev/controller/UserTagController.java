package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.domain.dto.TagListDTO;
import mentorship.dailydev.dailydev.service.UserTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserTagController {
    @Autowired
    private UserTagService userTagService;
    @PostMapping("user/{id}/tags")
    public void followTags(@PathVariable int id, @RequestBody TagListDTO tagsDTO){
        List<Tag> tags = tagsDTO.getTags();
        userTagService.followTags(id,tags);
    }

    @GetMapping("user/{id}/tags")
    public List<Tag> getFollowTags(@PathVariable int id){
        return userTagService.getFollowTags(id);
    }
}
