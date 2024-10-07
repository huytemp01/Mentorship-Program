package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.Category;
import mentorship.dailydev.dailydev.rowmapper.CategoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryDao {
    @Autowired
    private JdbcTemplate template;

    public Category getBy(String category) {
        try{
            return template.queryForObject("SELECT id,category_name FROM category WHERE category_name=?", new CategoryRowMapper(),category);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public void save(String category) {
        template.update("INSERT INTO category(category_name) VALUES(?)", category);
    }
}
