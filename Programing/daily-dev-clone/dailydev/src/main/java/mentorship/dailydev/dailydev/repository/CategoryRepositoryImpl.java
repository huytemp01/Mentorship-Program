package mentorship.dailydev.dailydev.repository;

import mentorship.dailydev.dailydev.dao.CategoryDao;
import mentorship.dailydev.dailydev.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl implements  CategoryRepository{
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public Category getByName(String category) {
        return categoryDao.getBy(category);
    }

    @Override
    public Category save(String category) {
        categoryDao.save(category);
        return categoryDao.getBy(category);
    }
}
