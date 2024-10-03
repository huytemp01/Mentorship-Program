package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.dao.TagDao;
import mentorship.dailydev.dailydev.domain.Tag;
import mentorship.dailydev.dailydev.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TagRepositoryImpl implements TagRepository {
    @Autowired
    private TagDao tagDao;
    @Override
    public List<Tag> getAll() {
        return tagDao.getAll();
    }
}
