package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.Tag;

import java.util.List;

public interface UserTagRepository {
    void save(int userId, List<Tag> tagId);

    List<Tag> getFollowTags(int userId);
    List<Tag> getFollowTags(String email);
}
