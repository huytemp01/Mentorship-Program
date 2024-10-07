package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String categoryName = rs.getString("category_name");
        return new Category(id, categoryName);
    }
}
