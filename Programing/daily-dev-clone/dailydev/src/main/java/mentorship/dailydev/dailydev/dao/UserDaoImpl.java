package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.User;
import mentorship.dailydev.dailydev.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl {
    @Autowired
    private JdbcTemplate template;

    public void save(User user){
        template.update("INSERT INTO users(email,password, user_name) VALUES(?,?,?)", user.getEmail(), user.getPassword(), user.getUserName());
    }

    public User findByEmail(String email) {
        try{
            return template.queryForObject("SELECT id, email, password, user_name FROM users u WHERE u.email =?",new UserRowMapper(), email);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public void deleteByEmail(String email) {
        template.update("DELETE FROM users where email=?", email);
    }

    public User getById(int id) {
        try{
            return template.queryForObject("SELECT id, email, password, user_name FROM users u WHERE u.id =?",new UserRowMapper(), id);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public void updatePassword(int id, String newPassword) {
        template.update("UPDATE users SET password =? WHERE id=?", newPassword, id);
    }
}
