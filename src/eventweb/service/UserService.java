package eventweb.service;

import eventweb.dao.DAOFactory;
import eventweb.dao.UserDAO;
import eventweb.model.User;

public class UserService {
    public void addUser(String username, String email, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(true);
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        userDao.create(user);
    }
    public User getUserById(long userId){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        User user = userDao.read(userId);
        return user;
    }
    public User getUserByUsername(String userName){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        User user = userDao.getUserByUsername(userName);
        return user;
    }
}
