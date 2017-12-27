package eventweb.service;

import eventweb.dao.DAOFactory;
import eventweb.dao.SignUpDAO;
import eventweb.model.SignUp;
import eventweb.model.User;


import java.util.List;

public class SignUpService {
    public void addList(Long eventId, Long userId){
        SignUp signUp = new SignUp(eventId,userId);
        DAOFactory factory = DAOFactory.getDAOFactory();
        SignUpDAO signUpDAO = factory.getSignUpDAO();
        signUpDAO.create(signUp);
    }
    public List<User> getAllUsersByEventId(Long key)
    {
        List<User> resultList = null;
        DAOFactory factory = DAOFactory.getDAOFactory();
        SignUpDAO dao = factory.getSignUpDAO();
        resultList = dao.readAllUsersByEvent(key);
        return resultList;
    }
}
