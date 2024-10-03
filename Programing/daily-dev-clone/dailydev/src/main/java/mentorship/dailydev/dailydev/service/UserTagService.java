package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Tag;

import java.util.List;

public interface UserTagService {
    void followTags(int userId, List<Tag> tags);

    List<Tag> getFollowTags(int userId);
}
