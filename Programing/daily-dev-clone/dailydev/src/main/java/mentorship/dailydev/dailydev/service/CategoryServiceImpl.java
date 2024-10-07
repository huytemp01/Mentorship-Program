package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Category;
import mentorship.dailydev.dailydev.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements  CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category getOrSave(String category) {
        if(isCategoryDuplicated(category)){
            return categoryRepository.getByName(category);
        }

        return categoryRepository.save(category);
    }


    private boolean isCategoryDuplicated(String category) {
        Category cate = categoryRepository.getByName(category);
        if(cate == null){
            return false;
        }
        return true;
    }
}
