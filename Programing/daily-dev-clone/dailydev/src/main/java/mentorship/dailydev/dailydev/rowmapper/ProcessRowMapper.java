package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.Process;
import mentorship.dailydev.dailydev.domain.Status;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ProcessRowMapper implements RowMapper<Process> {
    @Override
    public Process mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        int rssId = rs.getInt("rssId");
        Status status = Status.valueOf(rs.getString("Status"));
        LocalDateTime updateAt = rs.getTimestamp("updateAt").toLocalDateTime();
        int newPosts = rs.getInt("newPosts");
        return new Process(id,rssId,status,updateAt,newPosts);
    }
}
