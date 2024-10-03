package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.Tag;

import java.util.List;

public interface TagRepository {
    List<Tag> getAll();
}
