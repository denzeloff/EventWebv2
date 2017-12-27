package eventweb.controller;

import eventweb.model.EventCategory;
import eventweb.model.User;
import eventweb.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class NewEventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("inputTitle");
        String description = request.getParameter("inputDescription");
        EventCategory category = EventCategory.fromString(request.getParameter("inputCategory"));
        String date = request.getParameter("inputDate");
        String evenHour = request.getParameter("inputTime");
        String language = request.getParameter("inputLanguage");
        String city = request.getParameter("inputCity");
        String place = request.getParameter("inputPlace");
        String address = request.getParameter("inputAddress");
        String speakers = request.getParameter("inputSpeakers");
        int seats = Integer.parseInt(request.getParameter("inputSeats"));
        User authenticatedUser = (User) request.getSession().getAttribute("user");
        if (request.getUserPrincipal() != null) {
            EventService eventService = new EventService();
            eventService.addEvent(title, description, category, language, city, place, address, speakers, seats, date,evenHour, authenticatedUser);
            response.sendRedirect(request.getContextPath() + "/");
        } else
            response.sendError(403);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getUserPrincipal() != null) {
            request.getRequestDispatcher("/WEB-INF/newevent.jsp").forward(request, response);
        } else {
            response.sendError(403);
        }
    }
}
