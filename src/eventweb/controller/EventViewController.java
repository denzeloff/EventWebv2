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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // to jest pomoc jak bedziemy tworzyć zapisywanie do wydarzenia
       /* User logged = (User) request.getSession().getAttribute("user");
        if (logged != null) {
            long eventId = Long.parseLong(request.getParameter("event_id"));
            System.out.println(logged);
            //sprawdzenie czy user jest juz zapisany
            //Service zapisywania + model + dao
            //ustawienie atrybutu sesji na zapisany true
            //przekierowanie na inna strone
            //zmiana strony pod wzgledem buttony zapisania
            // response.sendRedirect(request.getContextPath());
            request.getRequestDispatcher("WEB-INF/event.jsp").forward(request, response);*/

    }

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
