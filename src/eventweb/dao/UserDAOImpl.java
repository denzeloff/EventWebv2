package eventweb.dao;

import eventweb.model.User;
import eventweb.util.ConnectionProvider;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String CREATE_USER = "INSERT INTO user(user_name,user_email,user_password,user_is_active) VALUES(:username,:email,:password,:active);";
    private static final String READ_USER = "SELECT user_id, user_name, user_email,user_password, user_is_active FROM user WHERE user_id = :id;";
    private static final String READ_USER_BY_USERNAME = "SELECT user_id,user_name,user_email,user_password,user_is_active FROM user where user_name=:username;";
    private NamedParameterJdbcTemplate template;

    public UserDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        User resultUser = null;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("username",username);
        resultUser = template.queryForObject(READ_USER_BY_USERNAME,sqlParameterSource,new UserRowMapper());
        return resultUser;
    }

    @Override
    public User create(User user) {
        User resultUser = new User(user);
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        int update = template.update(CREATE_USER, parameterSource, holder);
        if (update > 0) {
            resultUser.setId((Long) holder.getKey());
            setPrivigiles(resultUser);
        }
        return resultUser;
    }

    private void setPrivigiles(User user) {
        final String userRoleQuery = "INSERT INTO user_role(user_name)VALUES(:username);";
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        template.update(userRoleQuery, parameterSource);
    }

    @Override
    public User read(Long primaryKey) {
        User resultUser = null;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id",primaryKey);
        resultUser = template.queryForObject(READ_USER,sqlParameterSource,new UserRowMapper());
        return resultUser;
    }

    @Override
    public boolean update(User updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setUsername(resultSet.getString("user_name"));
            user.setEmail(resultSet.getString("user_email"));
            user.setPassword(resultSet.getString("user_password"));
            return user;
        }
    }
}
