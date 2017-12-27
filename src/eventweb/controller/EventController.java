package eventweb.controller;

import eventweb.model.Event;
import eventweb.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

@WebServlet("")
public class EventController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    saveEventInRequest(request);
    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }
    private void saveEventInRequest(HttpServletRequest request){
        EventService eventService = new EventService();
        List<Event> allEvents = eventService.getAllEvents(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                Timestamp event1 = o1.getTimestamp();
                Timestamp event2 = o2.getTimestamp();
                if (event1.after(event2)){
                    return -1;
                }else if (event2.after(event1)){
                    return 1;
                }
                return 0;
            }
        });
        request.setAttribute("events",allEvents);
    }
}
