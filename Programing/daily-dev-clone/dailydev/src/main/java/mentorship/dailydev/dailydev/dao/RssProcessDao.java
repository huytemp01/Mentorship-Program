package mentorship.dailydev.dailydev.dao;

import mentorship.dailydev.dailydev.domain.Process;
import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.Status;
import mentorship.dailydev.dailydev.rowmapper.ProcessRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class RssProcessDao {
    @Autowired
    private JdbcTemplate template;
    public void insert(RssLink rssLink) {
        template.update("INSERT INTO process(rssId, status, updateAt) VALUES(?,?,?)", rssLink.getId(), Status.NOTSTART.toString(), LocalDateTime.now());
//        template.update("INSERT INTO process(rssId, status, updateAt) VALUES(?,?,?)", rssLink.getId(), "notstart", LocalDateTime.now());
    }

    public int countNotStartProcess() {
        String da = LocalDate.now().toString();
        try{
            return template.queryForObject("SELECT count(id) FROM Process WHERE Status = ? and CAST(updateAt AS DATE) = ?",Integer.class, Status.NOTSTART.toString(), LocalDate.now().toString());
        }
        catch (EmptyResultDataAccessException e){
            return 0;
        }
//        return template.queryForObject("SELECT id FROM Process WHERE status = ? ", Integer.class,Status.NOTSTART.toString());
    }

    public List<Process> getProcessNotStartToday(int offset, int limit) {
        return template.query("SELECT id, rssid, status, updateAt, newPosts FROM process WHERE Status = ? and CAST(updateAt AS DATE) = ?  ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY",
                new ProcessRowMapper(),Status.NOTSTART.toString(), LocalDate.now().toString(), offset, limit );
    }

    public void updateProcessInfo(int id, int postCount) {
        template.update("Update process SET newPosts = ? , Status = ? WHERE id = ?", postCount, Status.SUCCESS.toString(), id);
    }
}
