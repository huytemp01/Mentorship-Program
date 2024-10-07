package mentorship.dailydev.dailydev.rowmapper;

import mentorship.dailydev.dailydev.domain.Source;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SourceRowMapper implements RowMapper<Source> {

    @Override
    public Source mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String domainName = rs.getString("domain_name");
        return new Source(id,domainName);
    }
}
