package eventweb.dao;

import eventweb.model.SignUp;
import eventweb.model.User;

import java.util.List;

public interface SignUpDAO extends GenericDAO<SignUp, Long> {
    List<SignUp> getAllByEventId();
    List<User> readAllUsersByEvent(Long eventKey);
}
