package eventweb.dao;

import eventweb.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User,Long>{
    User getUserByUsername(String username);
}
