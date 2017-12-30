package eventweb.controller;

import eventweb.model.Event;
import eventweb.model.User;
import eventweb.service.EventService;
import eventweb.service.SignUpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signUp")
public class SignUpController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User logged = (User) request.getSession().getAttribute("user");
        StringBuilder resultOperation = new StringBuilder();
        if (logged != null) {
            Long event_id = Long.valueOf(request.getParameter("id"));
            EventService eventService = new EventService();
            Event event = eventService.getEventById(event_id);
            SignUpService signUpService = new SignUpService();
            try {
                signUpService.addList(event.getId(), logged.getId());
                event.setSeats(event.getSeats() - 1);
                eventService.updateEvent(event);
                resultOperation.append("succes");
            }catch (RuntimeException e){
                resultOperation.append("fail");
            }

        } else {
            resultOperation.append("fail");
        }
        response.sendRedirect(request.getContextPath() + "/event?id=" + request.getParameter("id") + "&result=" + resultOperation.toString());
    }
}
