package eventweb.dao;

import eventweb.model.SignUp;
import eventweb.model.User;
import eventweb.util.ConnectionProvider;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpDAOImpl implements SignUpDAO {
    private static final String CREATE_LIST = "INSERT INTO event_has_users(event_id, user_id) VALUES (:event_id, :user_id);";
    private static final String READ_ALL_USERS_BY_EVENT = "SELECT user.user_id, user_name, user_email FROM event_has_users LEFT JOIN user ON event_has_users.user_id=user.user_id WHERE event_id = :event_id;";
    private NamedParameterJdbcTemplate template;

    public SignUpDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }
    @Override
    public List<SignUp> getAllByEventId() {
        return null;
    }

    @Override
    public SignUp create(SignUp signUp) {
        SignUp resultSignUp = new SignUp(signUp);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("event_id", resultSignUp.getEventId());
        paramMap.put("user_id", resultSignUp.getUserId());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_LIST,paramMap);
        if (update > 0) {
            System.out.println("Wszystko git");
        }
        return resultSignUp;
    }

    @Override
    public SignUp read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(SignUp updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    public List<User> readAllUsersByEvent(Long eventKey)
    {
        List<User> resultList = null;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("event_id",eventKey);
        resultList = template.query(READ_ALL_USERS_BY_EVENT, sqlParameterSource, new EventRowMapper());
        return resultList;
    }

    @Override
    public List<SignUp> getAll() {
        return null;
    }

    private class EventRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setUsername(resultSet.getString("user_name"));
            user.setEmail(resultSet.getString("user_email"));
            return user;
        }
    }
}
