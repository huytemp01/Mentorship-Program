package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Category;

public interface CategoryService {
    Category getOrSave(String category);

}
