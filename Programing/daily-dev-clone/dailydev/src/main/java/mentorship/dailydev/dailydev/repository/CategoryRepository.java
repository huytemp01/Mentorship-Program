package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.domain.Category;

public interface CategoryRepository {
    Category getByName(String category);

    Category save(String category);
}
