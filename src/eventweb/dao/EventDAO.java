package eventweb.dao;

import eventweb.model.Event;

import java.util.List;

public interface EventDAO extends GenericDAO<Event,Long> {
    List<Event> getAll();
}
