package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.domain.dto.TagDTO;
import mentorship.dailydev.dailydev.domain.dto.TagListDTO;
import mentorship.dailydev.dailydev.service.UserTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class UserTagController {
    @Autowired
    private UserTagService userTagService;
    @PostMapping("users/{id}/tags")
    public void followTags(@PathVariable int id, @RequestBody List<TagDTO> tagsDTO){
        List<Tag> tags = new ArrayList<>();
        for(TagDTO t:tagsDTO){
            Tag tag = new Tag(t.getId(), t.getTagName());
            tags.add(tag);
        }
        userTagService.followTags(id,tags);
    }

    @GetMapping("user/{id}/tags")
    public List<Tag> getFollowTags(@PathVariable int id){
        return userTagService.getFollowTags(id);
    }
}
