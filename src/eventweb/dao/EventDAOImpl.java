package eventweb.dao;

import eventweb.model.Event;
import eventweb.model.EventCategory;
import eventweb.model.User;
import eventweb.util.ConnectionProvider;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDAOImpl implements EventDAO {
    private static final String CREATE_EVENT = "INSERT INTO event(event_title,event_description,event_category,event_date,user_id,event_language,event_city,event_place,event_address,event_speakers,event_seats,event_date_time, event_date_hour)VALUES (:title, :description, :category, :timestamp, :user_id, :language, :city, :place, :address, :speakers, :seats, :date,:eventHour);";
    private static final String READ_ALL_EVENTS = "SELECT user.user_id, user_name, user_email, user_is_active, user_password, event_id, event_title, event_description, event_category, event_date, event_language, event_city, event_place, event_address,event_speakers,event_seats, event_date_time, event_date_hour FROM event LEFT JOIN user ON event.user_id=user.user_id;";
    private static final String READ_EVENT = "SELECT user.user_id, user_name, user_email, user_is_active, user_password, event_id, event_title, event_description, event_category, event_date, event_language, event_city, event_place, event_address,event_speakers,event_seats, event_date_time, event_date_hour FROM event LEFT JOIN user ON event.user_id=user.user_id WHERE event_id = :event_id;";
    private static final String UPDATE_EVENT = "UPDATE event SET event_seats=:seats WHERE event_id=:event_id;";
    private NamedParameterJdbcTemplate template;

    public EventDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public List<Event> getAll() {
        List<Event> events = template.query(READ_ALL_EVENTS, new EventRowMapper());
        return events;
    }

    @Override
    public Event create(Event event) {
        Event resultEvent = new Event(event);
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", event.getTitle());
        paramMap.put("description", event.getDescription());
        paramMap.put("category", event.getCategory().getCategory());
        paramMap.put("timestamp", event.getTimestamp());
        paramMap.put("user_id", event.getUser().getId());
        paramMap.put("language", event.getLanguage());
        paramMap.put("city", event.getCity());
        paramMap.put("place", event.getPlace());
        paramMap.put("address", event.getAddress());
        paramMap.put("speakers", event.getSpeakers());
        paramMap.put("seats", event.getSeats());
        paramMap.put("date", event.getDate());
        paramMap.put("eventHour",event.getEventHour());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_EVENT, sqlParameterSource, holder);
        if (update > 0) {
            resultEvent.setId((Long) holder.getKey());

        }
        return resultEvent;
    }

    @Override
    public Event read(Long primaryKey) {
        Event resultEvent = null;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("event_id", primaryKey);
        resultEvent = template.queryForObject(READ_EVENT, sqlParameterSource, new EventRowMapper());
        return resultEvent;
    }

    @Override
    public boolean update(Event event) {
        boolean result = false;
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("seats", event.getSeats());
        paramMap.put("event_id", event.getId());
        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        int update = template.update(UPDATE_EVENT,parameterSource);
        if (update>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    private class EventRowMapper implements RowMapper<Event> {
        @Override
        public Event mapRow(ResultSet resultSet, int i) throws SQLException {
            Event event = new Event();
            event.setId(resultSet.getLong("event_id"));
            event.setTitle(resultSet.getString("event_title"));
            event.setDescription(resultSet.getString("event_description"));
            event.setCategory(EventCategory.fromString(resultSet.getString("event_category")));
            event.setTimestamp(resultSet.getTimestamp("event_date"));
            event.setLanguage(resultSet.getString("event_language"));
            event.setCity(resultSet.getString("event_city"));
            event.setPlace(resultSet.getString("event_place"));
            event.setAddress(resultSet.getString("event_address"));
            event.setSpeakers(resultSet.getString("event_speakers"));
            event.setSeats(resultSet.getInt("event_seats"));
            event.setDate(resultSet.getString("event_date_time"));
            event.setEventHour(resultSet.getString("event_date_hour"));
            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setUsername(resultSet.getString("user_name"));
            user.setEmail(resultSet.getString("user_email"));
            user.setPassword(resultSet.getString("user_password"));
            event.setUser(user);
            return event;
        }
    }
}
