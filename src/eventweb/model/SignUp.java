package eventweb.model;

import java.sql.Timestamp;

public class SignUp {
    private long eventId;
    private long userId;

    public SignUp() {
    }

    public SignUp(SignUp signUp) {
        this.eventId = signUp.eventId;
        this.userId = signUp.userId;
    }

    public SignUp(long eventId, long userId) {
        this.eventId = eventId;
        this.userId = userId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SignUp signUp = (SignUp) o;

        if (eventId != signUp.eventId) return false;
        if (userId != signUp.userId) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (eventId ^ (eventId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return "SignUp{" +
                "eventId=" + eventId +
                ", userId=" + userId +
                '}';
    }
}
