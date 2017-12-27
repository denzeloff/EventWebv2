package eventweb.controller;

import eventweb.model.Event;
import eventweb.model.SignUp;
import eventweb.model.User;
import eventweb.service.EventService;
import eventweb.service.SignUpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/event")
public class EventViewController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long eventId = Long.parseLong(request.getParameter("id"));
        EventService eventService = new EventService();
        Event event = eventService.getEventById(eventId);
        request.setAttribute("event", event);
        SignUpService signUpService = new SignUpService();
        List<User> userList = signUpService.getAllUsersByEventId(event.getId());
        if (userList != null) {
            request.setAttribute("users", userList);
        }
        User logged = (User) request.getSession().getAttribute("user");
        if (logged != null) {
            request.setAttribute("user_id", logged.getId());
        }
        request.getRequestDispatcher("WEB-INF/event.jsp").forward(request, response);

    }
}
