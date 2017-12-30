package eventweb.controller;

import eventweb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/register")
public class RegisterController extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        StringBuilder resultOperation = new StringBuilder();
        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");
        String email = request.getParameter("inputEmail");
        UserService userService = new UserService();
        try {
            userService.addUser(username, email, password);
            resultOperation.append("success");
            response.sendRedirect(request.getContextPath() + "/?result="+resultOperation.toString());
        } catch (RuntimeException e) {
            resultOperation.append("fail");
            response.sendRedirect(request.getContextPath() + "/register?result="+resultOperation.toString());
        }
    }
}
