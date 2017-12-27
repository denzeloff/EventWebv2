package eventweb.service;

import eventweb.dao.DAOFactory;
import eventweb.dao.EventDAO;
import eventweb.model.Event;
import eventweb.model.EventCategory;
import eventweb.model.User;

import java.util.Comparator;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

public class EventService {

    public boolean updateEvent(Event event){
        DAOFactory factory = DAOFactory.getDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        boolean result = eventDAO.update(event);
        return result;
    }
    public void addEvent(String title, String description, EventCategory category,String language,String city, String place, String address, String speakers, int seats,String date,String eventHour, User user){
        Event event = createEventObject(title,description,category,language,city,place,address,speakers,seats,date,eventHour,user);
        DAOFactory factory = DAOFactory.getDAOFactory();
        EventDAO eventDao = factory.getEventDAO();
        eventDao.create(event);
    }
    private Event createEventObject(String title, String description, EventCategory category, String language, String city, String place, String address, String speakers, int seats, String date,String eventHour, User user){
    Event event = new Event();
    event.setTitle(title);
    event.setDescription(description);
    event.setCategory(category);
    event.setLanguage(language);
    event.setCity(city);
    event.setPlace(place);
    event.setAddress(address);
    event.setSpeakers(speakers);
    event.setSeats(seats);
    event.setDate(date);
    event.setEventHour(eventHour);
    User userCopy = new User(user);
    event.setUser(userCopy);
    event.setTimestamp(new Timestamp(new Date().getTime()));


    return event;
    }
    public List<Event>getAllEvents(){
        return getAllEvents(null);
    }
    public List<Event>getAllEvents(Comparator<Event> comparator){
        DAOFactory factory = DAOFactory.getDAOFactory();
        EventDAO eventDAO = factory.getEventDAO();
        List<Event> events = eventDAO.getAll();
        if(comparator!=null && events!=null){
            events.sort(comparator);
        }
        return events;
    }
    public Event getEventById(Long eventId){
        DAOFactory factory = DAOFactory.getDAOFactory();
        EventDAO eventDao = factory.getEventDAO();
        Event event = eventDao.read(eventId);
        return event;
    }
}
