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

@WebServlet("/signUp")
public class SignUpController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //pobieramy user z sesji
        //pobieramy event_id z atrybutu
        //pobieramy z bazy event
        //sprawdzamy czy event_user_id != user.id z sesji oraz
        //jezeli tak, SingUp do bazy
        //zmiejszenie ilosc miejsc z eventa
        //jezeli nie, odpowiedni komunikat dla usera np na poziomie atrubutu
        //sendDispatcher na event z odpowiednim id
        User logged = (User) request.getSession().getAttribute("user");
        StringBuilder resultOperation = new StringBuilder();
        if (logged != null) {
            Long event_id = Long.valueOf(request.getParameter("id"));
            EventService eventService = new EventService();
            Event event = eventService.getEventById(event_id);
           /* if (logged.getId()!=event.getUser().getId() && event.getSeats()>0){
            }*/
           event.setSeats(event.getSeats()-1);
           //update Eventu do bazy
            System.out.println(event.getSeats());
            SignUpService signUpService = new SignUpService();
            signUpService.addList(event.getId(),logged.getId());
            resultOperation.append("succes");
        }
        else{
            resultOperation.append("fail");
        }
        response.sendRedirect(request.getContextPath() + "/event?id=" +  request.getParameter("id") + "&result=" + resultOperation.toString());
        //request.getRequestDispatcher("WEB-INF/event.jsp?event_id=" + request.getParameter("event_id")).forward(request,response);
    }//patrz teraz
}
