package mentorship.dailydev.dailydev.controller;

import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {
    @Autowired
    public TagService tagService;

    @GetMapping("/tags")
    public List<Tag> getAllTag(){
        return tagService.getAllTags();
    }
}
