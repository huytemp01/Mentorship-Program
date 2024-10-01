package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl {
    @Autowired
    private JdbcTemplate template;

    public void save(User user){
        template.update("INSERT INTO user VALUES(?,?,?,?)", user.getId(), user.getEmail(), user.getPassword(), user.getUserName());
    }
}
