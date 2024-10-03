package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagRepository tagRepository;
    @Override
    public List<Tag> getAllTags() {
        return tagRepository.getAll();
    }
}
