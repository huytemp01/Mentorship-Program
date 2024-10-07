package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String username = rs.getString("user_name");
        return new User(id, email,password,username);
    }
}
