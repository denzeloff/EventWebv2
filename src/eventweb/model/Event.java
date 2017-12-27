package eventweb.model;

import java.sql.Timestamp;

public class Event {
    private long id;
    private String title;
    private String description;
    private EventCategory category;
    private Timestamp timestamp;
    private User user;
    private String language;
    private String city;
    private String place;
    private String address;
    private String speakers;
    private String date;
    private String eventHour;
    private int seats;

    public Event() {
    }

    public Event(Event event) {
        this.id = event.id;
        this.title = event.title;
        this.description = event.description;
        this.category = event.category;
        this.timestamp = event.timestamp;
        this.user = event.user;
        this.language = event.language;
        this.city = event.city;
        this.place = event.place;
        this.address = event.address;
        this.speakers = event.speakers;
        this.seats = event.seats;
        this.date = event.date;
        this.date = event.eventHour;
    }

    public String getEventHour() {
        return eventHour;
    }

    public void setEventHour(String eventHour) {
        this.eventHour = eventHour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp date) {
        this.timestamp = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (seats != event.seats) return false;
        if (title != null ? !title.equals(event.title) : event.title != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (category != event.category) return false;
        if (timestamp != null ? !timestamp.equals(event.timestamp) : event.timestamp != null) return false;
        if (user != null ? !user.equals(event.user) : event.user != null) return false;
        if (language != null ? !language.equals(event.language) : event.language != null) return false;
        if (city != null ? !city.equals(event.city) : event.city != null) return false;
        if (place != null ? !place.equals(event.place) : event.place != null) return false;
        if (address != null ? !address.equals(event.address) : event.address != null) return false;
        if (speakers != null ? !speakers.equals(event.speakers) : event.speakers != null) return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;
        return eventHour != null ? eventHour.equals(event.eventHour) : event.eventHour == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (speakers != null ? speakers.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (eventHour != null ? eventHour.hashCode() : 0);
        result = 31 * result + seats;
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", timestamp=" + timestamp +
                ", user=" + user +
                ", language='" + language + '\'' +
                ", city='" + city + '\'' +
                ", place='" + place + '\'' +
                ", address='" + address + '\'' +
                ", speakers='" + speakers + '\'' +
                ", date='" + date + '\'' +
                ", eventHour='" + eventHour + '\'' +
                ", seats=" + seats +
                '}';
    }
}

